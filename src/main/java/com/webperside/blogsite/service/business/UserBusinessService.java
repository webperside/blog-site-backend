package com.webperside.blogsite.service.business;

import com.webperside.blogsite.dto.request.UserRegisterRequest;
import com.webperside.blogsite.entity.dto.user.UserDTO;
import com.webperside.blogsite.entity.dto.user.UserProfileDTO;
import com.webperside.blogsite.entity.dto.user.UserSecurityDTO;
import com.webperside.blogsite.enums.common.ErrorEnum;
import com.webperside.blogsite.enums.user.EmailConfirmation;
import com.webperside.blogsite.enums.user.Gender;
import com.webperside.blogsite.enums.user.UserStatus;
import com.webperside.blogsite.exception.RestException;
import com.webperside.blogsite.service.functional.UserProfileService;
import com.webperside.blogsite.service.functional.UserSecurityService;
import com.webperside.blogsite.service.functional.UserService;
import com.webperside.blogsite.service.util.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserBusinessService {

    private final UserService userService;
    private final UserProfileService userProfileService;
    private final UserSecurityService userSecurityService;

    private final MailService mailService;

    @Transactional
    public void register(UserRegisterRequest request) {
        try{
            UserDTO user = saveUser(request);

            saveUserProfile(request, user);

            UserSecurityDTO security = saveUserSecurity(user);

            mailService.send(user.getUsername(), security.getEmailConfirmationCode());
        } catch (DataIntegrityViolationException ex){ // duplicate data
            RestException.of(ErrorEnum.USER_ALREADY_EXISTS).throwEx();
        }
    }

    private UserDTO saveUser(UserRegisterRequest req) {
        UserDTO user = UserDTO.builder()
                .username(req.getUsername())
                .password(req.getPassword())
                .status(UserStatus.NEW)
                .build();
        userService.insertOrUpdate(user);
        return user;
    }

    private void saveUserProfile(UserRegisterRequest req, UserDTO user) {
        userProfileService.insertOrUpdate(UserProfileDTO.builder()
                .user(user)
                .name(req.getName())
                .surname(req.getSurname())
                .gender(Gender.UNKNOWN)
                .build());
    }

    private UserSecurityDTO saveUserSecurity(UserDTO user) {
        UserSecurityDTO security = UserSecurityDTO.builder()
                .user(user)
                .emailConfirmation(EmailConfirmation.NOT_CONFIRMED)
                .emailConfirmationCode(UUID.randomUUID().toString())
                .build();

        userSecurityService.insertOrUpdate(security);

        return security;
    }

}
