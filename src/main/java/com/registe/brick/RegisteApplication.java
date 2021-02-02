package com.registe.brick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.registe.brick.userbrick.mapper")
@EntityScan(basePackages={"com.registe.brick.userbrick.entity"})
public class RegisteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisteApplication.class, args);
    }

}
