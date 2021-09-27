package com.webperside.blogsite.entity.dto.post;

import com.webperside.blogsite.entity.dto.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PostCategoryDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 5495757600022076851L;

    private Integer id;
    private PostDTO post;
    private CategoryDTO category;
}
