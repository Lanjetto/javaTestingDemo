package com.nexign.testUserService.service

import com.nexign.testUserService.model.User
import com.nexign.testUserService.repository.UserRepository
import spock.lang.Specification

class UserServiceSpockTest extends Specification {

    def "null login should failed"() {
        given:
        def mock = Mock(UserRepository)
        def service = new UserService(mock)
        when:
        service.login(null, null)
        then:
        thrown(IllegalArgumentException)
    }

//    Работа со Stub. Требуется добавить зависимость на UserRepository в UserCervice

/*    def "get users works fine"() {
        given:
        def user = new User("alex", "123")
        def stub = Stub(UserRepository) { getUserList() >> List.of(user) }
        def service = new UserService(stub)

        when:
        def users = service.getAllUsers()
        then:
        users == [user]
    }*/

}
