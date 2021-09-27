package com.webperside.blogsite.entity.dto.user;


import com.webperside.blogsite.entity.dto.base.BaseDTO;
import com.webperside.blogsite.entity.user.UserRoleEntity;
import com.webperside.blogsite.enums.user.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserRoleDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 8292178801446048300L;

    private Integer id;
    private UserDTO user;
    private Role role;

    public static UserRoleEntity toEntity(UserRoleDTO dto) {
        return UserRoleEntity.builder()
                .id(dto.getId())
                .user(UserDTO.toEntity(dto.getUser()))
                .role(dto.getRole())
                .createdAt(dto.getCreatedAt())
                .build();
    }

}
