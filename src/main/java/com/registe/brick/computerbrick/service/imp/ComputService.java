package com.registe.brick.computerbrick.service.imp;

import com.registe.brick.computerbrick.entity.Computer;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface ComputService {

    /**
     * 新增用户
     */
    public int insertUser(Computer computer);

    /**
     * 删除用户
     */
    public int deleteByPrimaryKey(String id);

    /**
     * 修改用户
     */
    public int updateByPrimaryKey(Computer computer);

    /**
     * 查询用户
     */
    public List<Computer> selectByExample(Example example);

}
