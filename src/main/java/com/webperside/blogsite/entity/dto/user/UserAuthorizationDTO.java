package com.webperside.blogsite.entity.dto.user;

import com.webperside.blogsite.entity.dto.base.BaseDTO;
import com.webperside.blogsite.entity.user.UserAuthorizationEntity;
import com.webperside.blogsite.enums.user.AuthType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserAuthorizationDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -8565782617410474760L;

    private Integer id;
    private UserDTO user;
    private String accessToken;
    private String refreshToken;
    private AuthType authType;

    public static UserAuthorizationEntity toEntity(UserAuthorizationDTO dto) {
        return UserAuthorizationEntity.builder()
                .id(dto.getId())
                .user(UserDTO.toEntity(dto.getUser()))
                .accessToken(dto.getAccessToken())
                .refreshToken(dto.getRefreshToken())
                .authType(dto.getAuthType())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
