package com.registe.brick.userbrick.service;

import com.registe.brick.userbrick.entity.User;
import com.registe.brick.userbrick.mapper.UserTkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceTk {

    @Autowired
    private UserTkMapper userMapper;

    /**
     * 根据名称查询用户
     * @param name
     * @return
     */
    public List<User> getUserByName(String name) {
        //使用tk-mybatis提供的selectByPrimaryKey方法
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        example.and(criteria);

        return userMapper.selectByExample(example);
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    public int saveUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * 查询所有
     * @return
     */
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    /**
     * 常用方法总结
     */
    public void allFUnctions() {

        //拼接条件查询
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        //字段范围查询
        criteria.andBetween("age", 4, 6);
        //字段匹配
        criteria.andEqualTo("age", 4);
        //大于等于
        criteria.andGreaterThanOrEqualTo("age", 5);

        //IN查询
        List<Integer> ages = new ArrayList<>();
        ages.add(1);
        ages.add(10);
        criteria.andIn("age", ages);
        example.and(criteria);
        List<User> userList1 = userMapper.selectByExample(example);

        for (User user : userList1) {
            System.out.println(user.getAge());

        }
    }


    public User createUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("111");
        return user;
    }


}
