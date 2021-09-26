package com.webperside.blogsite.entity.user;

import com.webperside.blogsite.entity.base.BaseEntity;
import com.webperside.blogsite.enums.user.EmailConfirmation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_security")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserSecurityEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -540111717621701697L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_security_id")
    private Integer id;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Enumerated
    @Column(name = "email_confirmation")
    private EmailConfirmation emailConfirmation;

    @Column(name = "email_confirmation_code")
    private String emailConfirmationCode;

    @Column(name = "password_reset_token")
    private String passwordResetToken;

    @Column(name = "password_reset_token_expire_date")
    private LocalDateTime passwordResetTokenExpireDate;

}
