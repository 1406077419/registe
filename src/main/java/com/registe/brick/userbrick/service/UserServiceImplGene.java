package com.registe.brick.userbrick.service;


import com.registe.brick.userbrick.entity.gen.User;
import com.registe.brick.userbrick.mapper.UserMapper;
import com.registe.brick.userbrick.service.impl.UserServiceGene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplGene implements UserServiceGene {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(String userId) {

        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int deleteByPrimaryKey(String userId) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
