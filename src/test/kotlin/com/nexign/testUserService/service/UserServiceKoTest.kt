package com.nexign.testUserService.service

import io.kotest.core.spec.style.BehaviorSpec

class UserServiceKoTest: BehaviorSpec({
    given("Create user service") {
        val userService = UserService()
        When("check all users") {
            val allUsers = userService.allUsers
            then("should empty") {
                allUsers.isEmpty()
            }
        }
    }
})