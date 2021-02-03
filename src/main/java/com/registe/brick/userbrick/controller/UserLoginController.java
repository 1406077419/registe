package com.registe.brick.userbrick.controller;

import com.registe.brick.userbrick.entity.gen.User;
import com.registe.brick.userbrick.service.UserServiceImplGene;
import com.registe.brick.userbrick.util.AuthUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021/2/2  fengjiale
 */
@Controller
@RequestMapping("/login")
public class UserLoginController {

    @Autowired
    private UserServiceImplGene userService;

    Logger logger = Logger.getLogger(UserLoginController.class);

    @RequestMapping(value = "/logincheck", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> loginCheck() {

        //@RequestParam("userName") String userName,@RequestParam("password") String password

        Map<String,String> resMap = new HashMap<>();

        //1、验证用户名密码
        User tempUser = new User();
        tempUser.setName("111");
        tempUser.setPassword("222");

        User user = userService.selectByNameAndPwd(tempUser);

        if (null != user){
            //生成token
            String token = AuthUtil.createToken(user.getId(),user.getName(),AuthUtil.EXPIRE_DATE);
            resMap.put("status","success");
            resMap.put("msg","登录成功");
            resMap.put("token",token);
        }else{
            resMap.put("status","fail");
            resMap.put("msg","用户名或密码错误");
        }

        return resMap;
    }

    @RequestMapping(value = "/loginout",method = RequestMethod.GET)
    public void loginOut() {

        //@RequestParam("token") String token
        String auth = AuthUtil.authMap.get("token");//传的token值
        AuthUtil.delToken(auth.split(",")[0],auth.split(",")[1]);
    }


}
