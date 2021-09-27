package com.webperside.blogsite.entity.dto.notification;


import com.webperside.blogsite.entity.dto.base.BaseDTO;
import com.webperside.blogsite.entity.dto.user.UserDTO;
import com.webperside.blogsite.enums.notification.NotificationStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class NotificationReceiverDTO extends BaseDTO implements Serializable {


    private static final long serialVersionUID = 8631858120661040394L;
    private Integer id;
    private NotificationDTO notification;
    private UserDTO user;
    private NotificationStatus status;


}
