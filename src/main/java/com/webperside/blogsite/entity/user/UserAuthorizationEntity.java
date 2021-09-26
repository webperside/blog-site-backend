package com.webperside.blogsite.entity.user;

import com.webperside.blogsite.entity.base.BaseEntity;
import com.webperside.blogsite.enums.user.AuthType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_authorization")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserAuthorizationEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -8565782617410474760L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_authorization_id")
    private Integer id;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Enumerated
    @Column(name = "auth_type")
    private AuthType authType;

}
