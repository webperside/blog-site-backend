package com.webperside.blogsite.entity.user;


import com.webperside.blogsite.entity.base.BaseEntity;
import com.webperside.blogsite.enums.user.Role;
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
@Table(name = "user_role")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserRoleEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 8292178801446048300L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_role_id")
    private Integer id;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Enumerated
    @Column(name = "role")
    private Role role;

}
