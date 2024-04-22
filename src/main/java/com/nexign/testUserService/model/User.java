package com.nexign.testUserService.model;



public class User {
    private Long id;
    private String login;
    private String password;
    private static Long idGenerator = 0L;

    public User(String login, String password) {
        this.id = idGenerator;
        idGenerator++;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Пользователь: " +
                id + " "  + login;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
