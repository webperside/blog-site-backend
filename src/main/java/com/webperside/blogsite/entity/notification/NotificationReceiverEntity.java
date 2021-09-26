package com.webperside.blogsite.entity.notification;


import com.webperside.blogsite.entity.base.BaseEntity;
import com.webperside.blogsite.entity.user.UserEntity;
import com.webperside.blogsite.enums.notification.NotificationStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notification_receiver")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class NotificationReceiverEntity extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 8631858120661040394L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_receiver_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_notification_id", referencedColumnName = "notification_id")
    private NotificationEntity notification;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Enumerated
    @Column(name = "status")
    private NotificationStatus status;


}
