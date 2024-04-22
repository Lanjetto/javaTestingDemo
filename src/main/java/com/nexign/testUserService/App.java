package com.nexign.testUserService;

import com.nexign.testUserService.repository.UserRepository;
import com.nexign.testUserService.service.UserService;

public class App {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        new UserService().getAllUsers();
    }
}
