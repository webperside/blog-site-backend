create table if not exists post
(
    post_id      int primary key auto_increment,
    fk_user_id   int          not null,
    header       varchar(100) null,
    header_photo varchar(255) null,
    body         LONGBLOB     null,
    viewed       int          not null,
    status       tinyint      not null,
    created_at   timestamp    not null default current_timestamp,
    constraint fk_user_id_post foreign key (fk_user_id) references user (user_id)
);

create table if not exists post_comment
(
    post_comment_id int primary key auto_increment,
    parent_id       int           null,
    fk_post_id      int           not null,
    fk_user_id      int           not null,
    comment         varchar(3000) not null,
    created_at      timestamp     not null default current_timestamp,
    constraint fk_post_id_post_comment foreign key (fk_post_id) references post (post_id),
    constraint fk_user_id_post_comment foreign key (fk_user_id) references user (user_id)
);

create index ix_parent_id_post_comment on post_comment (parent_id);

create table if not exists category
(
    category_id int primary key auto_increment,
    name        varchar(100) not null,
    created_at  timestamp    not null default current_timestamp
);

create table if not exists post_category
(
    post_category_id int primary key auto_increment,
    fk_post_id       int       not null,
    fk_category_id   int       not null,
    created_at       timestamp not null default current_timestamp
)