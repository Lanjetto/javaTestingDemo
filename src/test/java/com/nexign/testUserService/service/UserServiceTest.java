package com.nexign.testUserService.service;

import com.nexign.testUserService.model.User;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        System.out.println("UserService created");
    }

    @Test
    @DisplayName(value = "Мой первый тест")
    void helloTest() {
        System.out.println("Hello");
    }



    @Test
    void userListIsEmptyIfNoUsersAdded() {
        List<User> allUsers = userService.getAllUsers();
        assertTrue(allUsers.isEmpty(), "Список пользователей должен быть пуст");
    }
    @Test
    void userListContainOneUserIfUserAdded() {
        userService.addUsers(new User("Alex", "123"));
        List<User> allUsers = userService.getAllUsers();
        assertEquals(1, allUsers.size());
    }

    @Tag("login")
    @Test
    void loginSuccessIfLoginAndPasswordCorrect() {
        //given
        User user = new User("Alex", "123");
        userService.addUsers(user);
        //when
        Optional<User> optionalUser = userService.login("Alex", "123");
        //then
//        assertTrue(optionalUser.isPresent());
        assertThat(optionalUser.isPresent()).isTrue();
//        optionalUser.ifPresent(user1 -> assertEquals(user, user1));
        optionalUser.ifPresent(user1 -> assertThat(user).isEqualTo(user1));
    }

    @Test
    void userMapContainsUserKeyAndValues() {
        User user = new User("Alex", "123");
        User user1 = new User("Stas", "234");
        userService.addUsers(user, user1);

        Map<Long, User> userMap = userService.getUserMap();
        assertAll(
                () ->  assertThat(userMap).containsKeys(user.getId(), user1.getId()),
                () -> assertThat(userMap).containsValues(user, user1)
        );
    }
    @Tag("login")
    @Test
    void throwExceptionIfLoginOrPasswordIsNull() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> userService.login(null, "123")),
                () -> assertThrows(IllegalArgumentException.class, () -> userService.login("Alex", null))
        );
    }
    @ParameterizedTest
    @ValueSource(strings = {"Alex", "Stas", "Misha"})
        void loginParametrizedTest(String login) {
        User user = new User("Alex", "123");
        assertThat(login).isEqualTo(user.getLogin());
    }
}