package com.webperside.blogsite.controller;

import com.webperside.blogsite.dto.common.BaseResponse;
import com.webperside.blogsite.dto.request.UserRegisterRequest;
import com.webperside.blogsite.service.business.UserBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserBusinessService userBusinessService;

    @PostMapping
    public BaseResponse<Object> register(@RequestBody UserRegisterRequest req) {
        userBusinessService.register(req);
        return BaseResponse.success();
    }



}