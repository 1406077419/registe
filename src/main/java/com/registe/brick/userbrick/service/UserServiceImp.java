package com.registe.brick.userbrick.service;

import com.registe.brick.userbrick.dao.UserDao;
import com.registe.brick.userbrick.entity.User;
import com.registe.brick.userbrick.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByName(String name) {
        User user = userDao.findByName("1");
        //System.out.println(user.toString());
        return null;
    }

    @Override
    public boolean saveUser(User user) {

        User user2 = this.findByName(user.getName());
        if (null == user2){
            userDao.save(user);
            return true;
        }else{
            return false;
        }
    }
}
