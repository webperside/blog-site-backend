alter table user_security
    modify password_reset_token varchar(50),
    modify password_reset_token_expire_date datetime;
