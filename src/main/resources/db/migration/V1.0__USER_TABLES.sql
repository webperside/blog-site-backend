create table if not exists user (
    user_id int primary key auto_increment,
    username varchar(50) not null,
    password varchar(255) not null,
    user_status tinyint not null,
    created_at timestamp not null default current_timestamp
);

create index ix_user_username on user(username);

create table if not exists user_profile(
    user_profile_id int primary key auto_increment,
    fk_user_id int not null,
    name varchar(50) not null,
    surname varchar(50) not null,
    gender tinyint not null,
    photo varchar(255) null,
    birthdate date null,
    created_at timestamp not null default current_timestamp,
    constraint uc_fk_user_id_user_profile unique (fk_user_id),
    constraint fk_user_id_user_profile foreign key (fk_user_id) references user (user_id)
);

create table if not exists user_authorization (
    user_authorization_id int primary key auto_increment,
    fk_user_id int not null,
    access_token varchar(50) not null,
    refresh_token varchar(50) not null,
    auth_type tinyint not null,
    created_at timestamp not null default current_timestamp,
    constraint fk_user_id_user_authorization foreign key (fk_user_id) references user (user_id)
);

create index ix_user_authorization_auth_type on user_authorization(auth_type);

create table if not exists user_role(
    user_role_id int primary key auto_increment,
    fk_user_id int not null,
    role tinyint not null,
    created_at timestamp not null default current_timestamp,
    constraint fk_user_id_user_role foreign key (fk_user_id) references user (user_id)
);

create index ix_user_role_role on user_role(role);

create table if not exists user_security(
    user_security_id int primary key auto_increment,
    fk_user_id int not null,
    email_confirmation tinyint not null,
    email_confirmation_code varchar(50) not null,
    password_reset_token varchar(50) not null,
    password_reset_token_expire_date datetime not null,
    created_at timestamp not null default current_timestamp,
    constraint uc_fk_user_id_user_security unique (fk_user_id),
    constraint fk_user_id_user_security foreign key (fk_user_id) references user (user_id)
);