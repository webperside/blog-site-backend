package com.webperside.blogsite.entity.dto.user;

import com.webperside.blogsite.entity.dto.base.BaseDTO;
import com.webperside.blogsite.entity.user.UserProfileEntity;
import com.webperside.blogsite.enums.user.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserProfileDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -1958178774991731332L;

    private Integer id;
    private UserDTO user;
    private String name;
    private String surname;
    private Gender gender;
    private String photo;
    private LocalDate birthdate;

    public static UserProfileEntity toEntity(UserProfileDTO userProfileDTO) {
        return UserProfileEntity.builder()
                .id(userProfileDTO.getId())
                .user(UserDTO.toEntity(userProfileDTO.getUser()))
                .name(userProfileDTO.getName())
                .surname(userProfileDTO.getSurname())
                .gender(userProfileDTO.getGender())
                .photo(userProfileDTO.getPhoto())
                .birthdate(userProfileDTO.getBirthdate())
                .createdAt(userProfileDTO.getCreatedAt())
                .build();
    }
}
