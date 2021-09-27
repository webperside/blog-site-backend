package com.webperside.blogsite.service.functional;

import com.webperside.blogsite.entity.dto.user.UserAuthorizationDTO;
import com.webperside.blogsite.repository.UserAuthorizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthorizationService {

    private final UserAuthorizationRepository userAuthorizationRepository;

    public void insertOrUpdate(UserAuthorizationDTO userAuthorizationDTO) {
        userAuthorizationRepository.save(UserAuthorizationDTO.toEntity(userAuthorizationDTO));
    }
}
