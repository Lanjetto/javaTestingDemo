package com.nexign.testUserService.service

import org.junit.jupiter.api.Test

class UserServiceTestKt {
    @Test
    fun `Тест приветствия`() {
        println("Привет")
    }

    @Test
    fun `Список пользователей пуст если никто не добавлен`() {
        val userService = UserService()

        assert(userService.allUsers.isEmpty())

    }
}