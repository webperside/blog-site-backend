package com.webperside.blogsite.entity.user;

import com.webperside.blogsite.entity.base.BaseEntity;
import com.webperside.blogsite.enums.user.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_profile")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserProfileEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1958178774991731332L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_profile_id")
    private Integer id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Enumerated
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "photo")
    private String photo;

    @Column(name = "birthdate")
    private LocalDate birthdate;

}
