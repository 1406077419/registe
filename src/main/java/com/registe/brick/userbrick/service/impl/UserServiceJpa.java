package com.registe.brick.userbrick.service.impl;

import com.registe.brick.userbrick.entity.User;

import java.util.List;

public interface UserServiceJpa {


    User findByName(String name);

    boolean saveUser(User user);

}
