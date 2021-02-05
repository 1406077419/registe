package com.registe.brick.userbrick.service;

import com.registe.brick.userbrick.dao.UserDaoJpa;
import com.registe.brick.userbrick.entity.User;
import com.registe.brick.userbrick.service.impl.UserServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpJpa implements UserServiceJpa {

    @Autowired
    private UserDaoJpa userDao;

    @Override
    public User findByName(String name) {
        User user = userDao.findByName("1");
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
