package com.registe.brick.userbrick.mapper;

import com.registe.brick.userbrick.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface UserTkMapper extends Mapper<User> {

    @Select("SELECT MAX(age) FROM `user`")
    int getMaxAge();
}
