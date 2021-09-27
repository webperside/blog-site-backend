package com.webperside.blogsite.entity.dto.post;

import com.webperside.blogsite.entity.dto.base.BaseDTO;
import com.webperside.blogsite.entity.dto.user.UserDTO;
import com.webperside.blogsite.enums.post.PostStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PostDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -8799280017635445273L;

    private Integer id;
    private UserDTO user;
    private String header;
    private String headerPhoto;
    private String body;
    private Integer viewed;
    private PostStatus status;

}
