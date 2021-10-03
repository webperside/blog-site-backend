package com.webperside.blogsite.service.business;

import com.webperside.blogsite.dto.request.UserRegisterRequest;
import com.webperside.blogsite.entity.dto.user.UserDTO;
import com.webperside.blogsite.entity.dto.user.UserProfileDTO;
import com.webperside.blogsite.entity.dto.user.UserRoleDTO;
import com.webperside.blogsite.entity.dto.user.UserSecurityDTO;
import com.webperside.blogsite.enums.user.EmailConfirmation;
import com.webperside.blogsite.enums.user.Gender;
import com.webperside.blogsite.enums.user.Role;
import com.webperside.blogsite.enums.user.UserStatus;
import com.webperside.blogsite.service.functional.UserProfileService;
import com.webperside.blogsite.service.functional.UserRoleService;
import com.webperside.blogsite.service.functional.UserSecurityService;
import com.webperside.blogsite.service.functional.UserService;
import com.webperside.blogsite.service.util.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserBusinessServiceTests {

    //captors
    @Captor
    private ArgumentCaptor<UserDTO> user;
    @Captor
    private ArgumentCaptor<UserProfileDTO> userProfile;
    @Captor
    private ArgumentCaptor<UserSecurityDTO> userSecurity;
    @Captor
    private ArgumentCaptor<UserRoleDTO> userRole;

    // mocks
    @Mock
    private UserService userService;
    @Mock
    private UserRoleService userRoleService;
    @Mock
    private UserProfileService userProfileService;
    @Mock
    private UserSecurityService userSecurityService;
    @Mock
    private MailService mailService;

    @InjectMocks
    private UserBusinessService userBusinessService;

    @Test
    public void register_whenRequestIsCorrect() {
        // given
        UserRegisterRequest req = prepareRequest();

        // when
        doAnswer(invocationOnMock -> {
            UserDTO userDto = invocationOnMock.getArgument(0);
            userDto.setId(1);
            return userDto;
        }).when(userService).insertOrUpdate(user.capture());

        doNothing().when(userProfileService).insertOrUpdate(userProfile.capture());
        doNothing().when(userSecurityService).insertOrUpdate(userSecurity.capture());
        doNothing().when(userRoleService).insertOrUpdate(userRole.capture());
        doNothing().when(mailService).send(any(), any());

        // execute
        userBusinessService.register(req);

        // verify
        verify(userService, times(1)).insertOrUpdate(user.getValue());
        verify(userProfileService, times(1)).insertOrUpdate(userProfile.getValue());
        verify(userSecurityService, times(1)).insertOrUpdate(userSecurity.getValue());
        verify(userRoleService, times(1)).insertOrUpdate(userRole.getValue());
        verify(mailService, times(1)).send(any(), any());

        // asserts user
        UserDTO userDto = user.getValue();
        System.out.println(userDto);
        assertThat(userDto.getId()).isEqualTo(1);
        assertThat(userDto.getUsername()).isEqualTo(req.getUsername());
        assertThat(userDto.getStatus()).isEqualTo(UserStatus.NEW);

        // asserts profile
        UserProfileDTO userProfileDto = userProfile.getValue();
        System.out.println(userProfileDto);
        assertThat(userProfileDto.getUser()).isEqualTo(userDto);
        assertThat(userProfileDto.getName()).isEqualTo(req.getName());
        assertThat(userProfileDto.getSurname()).isEqualTo(req.getSurname());
        assertThat(userProfileDto.getGender()).isEqualTo(Gender.UNKNOWN);

        // asserts security
        UserSecurityDTO userSecurityDto = userSecurity.getValue();
        System.out.println(userSecurityDto);
        assertThat(userSecurityDto.getUser()).isEqualTo(userDto);
        assertThat(userSecurityDto.getEmailConfirmation()).isEqualTo(EmailConfirmation.NOT_CONFIRMED);
        assertThat(userSecurityDto.getEmailConfirmationCode()).isNotBlank();

        // asserts role
        UserRoleDTO userRoleDto = userRole.getValue();
        System.out.println(userRoleDto);
        assertThat(userRoleDto.getUser()).isEqualTo(userDto);
        assertThat(userRoleDto.getRole()).isEqualTo(Role.USER);
    }

    private UserRegisterRequest prepareRequest() {
        UserRegisterRequest req = new UserRegisterRequest();
        req.setName("Hamid");
        req.setSurname("Sultanzadeh");
        req.setUsername("hamid.sultanzadeh@gmail.com");
        req.setPassword("12345");
        return req;
    }
}
