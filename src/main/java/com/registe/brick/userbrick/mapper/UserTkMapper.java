package com.registe.brick.userbrick.mapper;

import com.registe.brick.userbrick.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface UserTkMapper extends Mapper<User> {


}
