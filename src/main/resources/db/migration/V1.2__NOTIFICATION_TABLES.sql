create table if not exists notification_content
(
    notification_content_id int primary key auto_increment,
    header                  varchar(100) not null,
    body                    varchar(200) not null,
    icon                    varchar(255) not null,
    created_at              timestamp    not null default current_timestamp
);

create table if not exists notification
(
    notification_id            int primary key auto_increment,
    fk_notification_content_id int       not null,
    related_id                 int       null,
    type                       tinyint   not null,
    created_at                 timestamp not null default current_timestamp,
    constraint fk_notification_content_id_notification foreign key (fk_notification_content_id) references notification_content (notification_content_id)
);

create table if not exists notification_receiver
(
    notification_receiver_id int primary key auto_increment,
    fk_notification_id       int       not null,
    fk_user_id               int       not null,
    status                   tinyint   not null,
    created_at               timestamp not null default current_timestamp,
    constraint fk_notification_id_notification_receiver foreign key (fk_notification_id) references notification (notification_id),
    constraint fk_user_id_notification_receiver foreign key (fk_user_id) references user (user_id)
);
