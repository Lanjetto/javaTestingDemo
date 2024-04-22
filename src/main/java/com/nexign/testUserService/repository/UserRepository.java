package com.nexign.testUserService.repository;

import com.nexign.testUserService.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserRepository {
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }
}
