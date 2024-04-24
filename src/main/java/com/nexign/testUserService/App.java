package com.nexign.testUserService;

import com.nexign.testUserService.service.UserService;

public class App {
    public static void main(String[] args) {
        new UserService().getAllUsers();
    }
}
