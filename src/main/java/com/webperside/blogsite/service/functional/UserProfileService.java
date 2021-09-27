package com.webperside.blogsite.service.functional;

import com.webperside.blogsite.entity.dto.user.UserProfileDTO;
import com.webperside.blogsite.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public void insertOrUpdate(UserProfileDTO userProfileDTO) {
        userProfileRepository.save(UserProfileDTO.toEntity(userProfileDTO));
    }
}
