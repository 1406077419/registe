package com.registe.brick.computerbrick.service;

import com.registe.brick.computerbrick.entity.Computer;
import com.registe.brick.computerbrick.mapper.ComputMapper;
import com.registe.brick.computerbrick.service.imp.ComputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ComputServiceImp implements ComputService {

    @Autowired
    private ComputMapper computMapper;

    @Override
    public int insertUser(Computer computer) {
        return computMapper.insert(computer);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return computMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Computer computer) {
        return computMapper.updateByPrimaryKey(computer);
    }

    @Override
    public List<Computer> selectByExample(Example example) {
        return computMapper.selectByExample(example);
    }
}
