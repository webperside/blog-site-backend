package com.webperside.blogsite.entity.dto.user;

import com.webperside.blogsite.entity.dto.base.BaseDTO;
import com.webperside.blogsite.entity.user.UserEntity;
import com.webperside.blogsite.enums.user.UserStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1638302288188183023L;

    private Integer id;
    private String username;
    private String password;
    private UserStatus status;

    public static UserEntity toEntity(UserDTO dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .status(dto.getStatus())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
