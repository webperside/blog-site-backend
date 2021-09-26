package com.webperside.blogsite.entity.notification;

import com.webperside.blogsite.entity.base.BaseEntity;
import com.webperside.blogsite.enums.notification.NotificationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "notification")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class NotificationEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8922832045843568221L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Integer id;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "fk_notification_content_id", referencedColumnName = "notification_content_id")
    private NotificationContentEntity content;

    @Column(name = "related_id")
    private Integer relatedId;

    @Enumerated
    @Column(name = "type")
    private NotificationType notificationType;
}
