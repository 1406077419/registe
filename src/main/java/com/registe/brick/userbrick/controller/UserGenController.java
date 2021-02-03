package com.registe.brick.userbrick.controller;

import com.registe.brick.userbrick.entity.gen.User;
import com.registe.brick.userbrick.service.UserServiceImplGene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2021/2/2  fengjiale
 */
@RestController()
@RequestMapping("/user")
public class UserGenController {

    @Autowired
    private UserServiceImplGene userService;


    @RequestMapping("/queryUserById")
    public void selectUserById() {

        System.out.println("查询用户-------");
        String id = "1695206c-96b9-4ba5-bb6f-b07ca6461dda";
        User user = userService.selectByPrimaryKey(id);
        System.out.println(user.toString());
        //return user;
    }
}
