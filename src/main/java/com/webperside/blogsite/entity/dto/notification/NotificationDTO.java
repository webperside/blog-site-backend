package com.webperside.blogsite.entity.dto.notification;

import com.webperside.blogsite.entity.dto.base.BaseDTO;
import com.webperside.blogsite.enums.notification.NotificationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class NotificationDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 8922832045843568221L;

    private Integer id;
    private NotificationContentDTO content;
    private Integer relatedId;
    private NotificationType notificationType;
}
