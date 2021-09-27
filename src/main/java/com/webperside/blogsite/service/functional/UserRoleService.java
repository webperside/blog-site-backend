package com.webperside.blogsite.service.functional;

import com.webperside.blogsite.entity.dto.user.UserRoleDTO;
import com.webperside.blogsite.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public void insertOrUpdate(UserRoleDTO userRoleDTO) {
        userRoleRepository.save(UserRoleDTO.toEntity(userRoleDTO));
    }

}
