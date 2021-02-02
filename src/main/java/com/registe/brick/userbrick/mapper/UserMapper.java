package com.registe.brick.userbrick.mapper;

import com.registe.brick.userbrick.entity.gen.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    User selectByNameAndPwd(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}