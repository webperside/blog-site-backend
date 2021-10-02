package com.webperside.blogsite.service.functional;

import com.webperside.blogsite.entity.dto.user.UserDTO;
import com.webperside.blogsite.entity.user.UserEntity;
import com.webperside.blogsite.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void insertOrUpdate(UserDTO userDto) {
        UserEntity entity = UserDTO.toEntity(userDto);
        userRepository.save(entity);
        userDto.setId(entity.getId());
    }
}
