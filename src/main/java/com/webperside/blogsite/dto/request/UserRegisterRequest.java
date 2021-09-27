package com.webperside.blogsite.dto.request;

import lombok.Data;

@Data
public class UserRegisterRequest {

    private String name;
    private String surname;
    private String username;
    private String password;

}
