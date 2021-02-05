package com.registe.brick.userbrick.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.registe.brick.userbrick.entity.User;
import com.registe.brick.userbrick.mapper.UserTkMapper;
import com.registe.brick.userbrick.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceTk {

    @Autowired
    private UserTkMapper userMapper;

    /**
     * 根据名称查询用户
     *
     * @param name
     * @return
     */
    public List<User> getUserByName(String name) {

        Example example = Example.builder(User.class).where(Sqls.custom().andEqualTo("name", name)).build();
        return userMapper.selectByExample(example);
    }

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    public int saveUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    /**
     * 查询数量
     *
     * @param name
     * @return
     */
    public int getCountByName(String name) {

        int count = userMapper.selectCountByExample(Example.builder(User.class).select("name").where(Sqls.custom().andEqualTo("name", name)).build());

        return count;
    }

    /**
     * 查询最大值
     */
    public int getMax() {
        int max = userMapper.getMaxAge();
        System.out.println(max);
        return max;
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

    /**
     * 分页查询
     */
    public void getPage(PageUtil pageUtil) {
        // 第一种 多条件拼接查询
        Example example = Example.builder(User.class)
                .where(Sqls.custom().andGreaterThan("age", 1))
                .orderBy("createtime")
                .build();

        PageHelper.startPage(pageUtil.getPageNum(), pageUtil.getPageSize());
        PageInfo<User> pageInfo = new PageInfo<User>(userMapper.selectByExample(example));
        List<User> userList = pageInfo.getList();

        // 第二种 一条lamda拼接所有条件处理
        Page<User> page = PageHelper.startPage(pageUtil.getPageNum(), pageUtil.getPageSize()).doSelectPage(() -> userMapper.selectByExample(example));
        List<User> userList2 = page.getResult();
    }

}
