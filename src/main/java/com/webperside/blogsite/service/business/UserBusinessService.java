package com.webperside.blogsite.service.business;

import com.webperside.blogsite.dto.request.UserRegisterRequest;
import com.webperside.blogsite.service.functional.UserProfileService;
import com.webperside.blogsite.service.functional.UserSecurityService;
import com.webperside.blogsite.service.functional.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBusinessService {

    private final UserService userService;
    private final UserProfileService userProfileService;
    private final UserSecurityService userSecurityService;

    public void register(UserRegisterRequest request) {
        // bla
        // bla
        // bla
    }

}
