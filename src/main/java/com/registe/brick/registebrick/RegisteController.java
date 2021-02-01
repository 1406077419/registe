package com.registe.brick.registebrick;

import com.registe.brick.userbrick.entity.User;
import com.registe.brick.userbrick.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/registe")
public class RegisteController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userregiste")
    public void userRegiste(){

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("huangsan");
        boolean saveFlag = userService.saveUser(user);
        System.out.println(saveFlag);

    }

}
