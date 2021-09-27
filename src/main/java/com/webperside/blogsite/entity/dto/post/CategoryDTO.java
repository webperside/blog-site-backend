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
public class CategoryDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -1060154553223082700L;

    private Integer id;
    private String name;

}
