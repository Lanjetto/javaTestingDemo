package com.nexign.testUserService.service

import com.nexign.testUserService.model.User
import org.junit.jupiter.api.Test

class UserServiceTestGroovy {
    @Test
    void "список пользователей пуст, если никто не добавлен"() {
        def userService = new UserService()
        userService.addUsers(new User("Alex", "123"))
        def users = userService.allUsers
        assert users.isEmpty()
    }
}
