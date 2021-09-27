package com.webperside.blogsite.service.functional;

import com.webperside.blogsite.entity.dto.user.UserSecurityDTO;
import com.webperside.blogsite.repository.UserSecurityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSecurityService {

    private final UserSecurityRepository userSecurityRepository;

    public void insertOrUpdate(UserSecurityDTO dto) {
        userSecurityRepository.save(UserSecurityDTO.toEntity(dto));
    }
}
