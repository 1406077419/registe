package com.registe.brick;

import com.registe.brick.userbrick.entity.User;
import com.registe.brick.userbrick.service.impl.UserServiceJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class RegisteApplicationTests {

    @Autowired
    private UserServiceJpa userService;

    @Test
    void saveUser(){

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("huangsan2");
        boolean saveFlag = userService.saveUser(user);
        System.out.println(saveFlag);
    }

}
