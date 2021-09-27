package com.webperside.blogsite.entity.dto.notification;

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
public class NotificationContentDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1333737365017060459L;

    private Integer id;
    private String header;
    private String body;
    private String icon;

}
