package com.registe.brick.userbrick.service.impl;

import com.registe.brick.userbrick.entity.gen.User;
import org.springframework.stereotype.Service;

public interface UserServiceGene {

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    User selectByNameAndPwd(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
