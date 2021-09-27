package com.webperside.blogsite.entity.dto.post;

import com.webperside.blogsite.entity.dto.base.BaseDTO;
import com.webperside.blogsite.entity.dto.user.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PostCommentDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -6983380385702960452L;

    private Integer id;
    private Integer parentId;
    private PostDTO post;
    private UserDTO user;
    private String comment;

}
