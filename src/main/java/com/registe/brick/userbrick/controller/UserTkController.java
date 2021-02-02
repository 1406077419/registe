package com.registe.brick.userbrick.controller;

import com.registe.brick.userbrick.entity.User;
import com.registe.brick.userbrick.service.UserServiceTk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tkuser2")
public class UserTkController {

    @Autowired
    private UserServiceTk userService;

    @GetMapping("getAll")
    public void getAll() {
        System.out.println(111);
        //return this.userService.getAllUser();
        userService.allFUnctions();
    }

}
