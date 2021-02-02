package com.registe.brick.computerbrick.mapper;

import com.registe.brick.computerbrick.entity.Computer;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface ComputMapper extends Mapper<Computer> {
}
