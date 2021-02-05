package com.registe.brick.userbrick.controller;

import com.registe.brick.userbrick.entity.User;
import com.registe.brick.userbrick.service.UserServiceTk;
import com.registe.brick.userbrick.service.impl.UserServiceJpa;
import com.registe.brick.userbrick.util.RegisteThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 2021/1/5  fengjiale
 */
@Controller
@RequestMapping("/registe")
public class UserRegisteController {

    @Autowired
    private UserServiceJpa userService;

    @Autowired
    private UserServiceTk userServiceTk;

    @Autowired
    private StringRedisTemplate redisTemplate;

    //过期时间过长
    private long expireTime = 2000l;

    String[] nameArr = {"关羽", "张飞", "刘备", "曹操", "马超", "孙权", "周瑜","吕布","袁绍","华雄","司马懿","曹冲","曹植"};

    @RequestMapping(value = "/userregiste", method = RequestMethod.GET)
    @ResponseBody
    public int userRegiste() {

        String name = nameArr[(int) (Math.random() * nameArr.length)];

        //redis加锁
        Boolean result = redisTemplate.opsForValue().setIfAbsent(name, name,
                expireTime, TimeUnit.MILLISECONDS);

        if (false == result) {
            System.out.println(Thread.currentThread().getName() + "  &&&注册失败,缓存重命名 " + name);
            return 0;
        } else {
            //二次校验数据库
            //高并发状态下校验数据库返回信息太多占用网络带宽和资源
            int count = userServiceTk.getCountByName(name);
            if (0 == count) {
                userServiceTk.saveUser(createUser(name));
                System.out.println(Thread.currentThread().getName() + "  --------注册成功   " + name);
                return 1;
            } else {
                System.out.println(Thread.currentThread().getName() + "  注册失败,***入库重命名 " + name);
                return 0;
            }
        }
    }

    private int sum = 5;

    @RequestMapping(value = "/getCourse", method = RequestMethod.GET)
    @ResponseBody
    public void userRegisteByDb() {

        String courseName = "数学";

        String curNum = redisTemplate.opsForValue().get(courseName);
        if (null != curNum) {
            try {
                redisTemplate.opsForValue().increment(courseName, 5);
                System.out.println("---  抢课成功");
            } catch (Exception e) {
                System.out.println("&&&&   抢完了");

            }
            /*int ccNuum = Integer.parseInt(curNum);
            if (ccNuum < sum) {
                redisTemplate.opsForValue().setIfPresent(courseName, ++ccNuum + "",expireTime,TimeUnit.MILLISECONDS);
            } else {
                System.out.println("&&&&   抢完了");
            }*/
        } else {
            redisTemplate.opsForValue().set(courseName,1+"");
            System.out.println("----   第一票");
        }

        System.out.println(curNum);

    }


    @RequestMapping(value = "/userregistebydb", method = RequestMethod.GET)
    @ResponseBody
    public int getCourse() {

        String name = nameArr[(int) (Math.random() * nameArr.length)];

        //一次校验数据库
        List<User> curUser = userServiceTk.getUserByName(name);
        if (0 == curUser.size()) {
            userServiceTk.saveUser(createUser(name));
            System.out.println(Thread.currentThread().getName() + "  --------注册成功   " + name);
            return 1;
        } else {
            System.out.println(Thread.currentThread().getName() + "  注册失败,***入库重命名 " + name);
            return 0;
        }
    }

    public User createUser(String name) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        user.setAge((int)(Math.random() * nameArr.length));
        user.setCreatetime(System.currentTimeMillis());
        user.setRealname(name);
        return user;
    }

    /*public void testRegist(){

        //1.  2个线程分别启用100个注册请求
        RegisteThread registeThread = new RegisteThread();
        Thread t1 = new Thread(registeThread);
        Thread t2 = new Thread(registeThread);
        Thread t3 = new Thread(registeThread);
        Thread t4 = new Thread(registeThread);
        Thread t5 = new Thread(registeThread);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t4.setName("线程4");
        t5.setName("线程5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }*/

    public void releaseLock(String lockId) {
        redisTemplate.delete(lockId);
    }

    @RequestMapping("/registeoflock")
    public void registeOfLock() {

        System.out.println(111);
        String[] nameArr = {"关羽", "张飞", "刘备", "曹操", "马超", "孙权", "周瑜"};
        RegisteThread registeThread1 = new RegisteThread();

    }

    @RequestMapping("/registetest")
    public void userRegiste2() {

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("huangsan5");
        boolean saveFlag = userService.saveUser(user);
        System.out.println(saveFlag);
    }

}
