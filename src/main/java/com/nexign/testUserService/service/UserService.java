package com.nexign.testUserService.service;

import com.nexign.testUserService.model.User;
import com.nexign.testUserService.repository.UserRepository;
import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class UserService {
    private final List<User> userList = new ArrayList<>();
//    private final UserRepository userList;

//    public UserService(UserRepository userList) {
//        this.userList = userList;
//    }

    public void addUsers(User...users) {
        userList.addAll(Arrays.asList(users));
        System.out.printf("All users %s added", Arrays.toString(users));
    }

    public List<User> getAllUsers() {
        System.out.println("User list: " + userList);
        return userList;
    }

    public Optional<User> login(String login, String password) {
        if (login == null || password == null) {
            throw new IllegalArgumentException("login or pass is null");
        }
        return userList.stream()
                .filter(user -> user.getLogin().equals(login))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }
    public Map<Long, User> getUserMap() {
        return userList.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
    }

}
