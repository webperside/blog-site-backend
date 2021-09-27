package com.webperside.blogsite.entity.dto.user;

import com.webperside.blogsite.entity.dto.base.BaseDTO;
import com.webperside.blogsite.entity.user.UserSecurityEntity;
import com.webperside.blogsite.enums.user.EmailConfirmation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserSecurityDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -540111717621701697L;

    private Integer id;
    private UserDTO user;
    private EmailConfirmation emailConfirmation;
    private String emailConfirmationCode;
    private String passwordResetToken;
    private LocalDateTime passwordResetTokenExpireDate;

    public static UserSecurityEntity toEntity(UserSecurityDTO userSecurityDTO) {
        return UserSecurityEntity.builder()
                .id(userSecurityDTO.getId())
                .user(UserDTO.toEntity(userSecurityDTO.getUser()))
                .emailConfirmation(userSecurityDTO.getEmailConfirmation())
                .emailConfirmationCode(userSecurityDTO.getEmailConfirmationCode())
                .passwordResetToken(userSecurityDTO.getPasswordResetToken())
                .passwordResetTokenExpireDate(userSecurityDTO.getPasswordResetTokenExpireDate())
                .createdAt(userSecurityDTO.getCreatedAt())
                .build();
    }
}
