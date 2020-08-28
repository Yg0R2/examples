package com.yg0r2.dummy.auth.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean isExist(String userName, String password) {
        return "test".equals(userName) && "test".equals(password);
    }

}
