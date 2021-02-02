package com.registe.brick.userbrick.util;

import com.registe.brick.userbrick.entity.User;
import com.registe.brick.userbrick.service.UserServiceTk;
import com.registe.brick.userbrick.service.impl.UserServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RegisteThread implements Runnable {

    //通过上下文获取实例
    private StringRedisTemplate redisTemplate = ApplicationContextProvider.getBean(StringRedisTemplate.class);

    private UserServiceTk userServiceTk = ApplicationContextProvider.getBean(UserServiceTk.class);;

    private long expireTime = 10000l;

    //String[] nameArr = {"关羽", "张飞", "刘备", "曹操", "马超", "孙权", "周瑜"};
    String[] nameArr = {"关羽", "张飞", "刘备"};

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            String name = nameArr[(int) (Math.random() * nameArr.length)];
            //存到redis缓存
            Boolean result = redisTemplate.opsForValue().setIfAbsent(name, name,
                    expireTime, TimeUnit.MILLISECONDS);

            if (false == result) {
                System.out.println(Thread.currentThread().getName() + "  &&&注册失败,缓存重命名 " + name);
            } else {
                //二次校验数据库
                List<User> curUser = userServiceTk.getUserByName(name);
                if (0 == curUser.size()) {
                    userServiceTk.saveUser(createUser(name));
                    System.out.println(Thread.currentThread().getName() + "  --------注册成功   " + name);
                } else {
                    System.out.println(Thread.currentThread().getName() + "  注册失败,***入库重命名 " + name);
                }
            }
        }
    }

    public User createUser(String name) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        return user;
    }

}
