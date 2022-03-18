package com.example.mybatisPlus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisPlus.enums.SexEnums;
import com.example.mybatisPlus.mapper.UserMapper;
import com.example.mybatisPlus.pojo.User;
import com.example.mybatisPlus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

class MybatisplusApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testMapper(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

//    @Test
//    void testInsert(){
//        User user = new User();
//        user.setAge(10);
//        user.setName("网三");
//        user.setEmail("44672@qq.com");
//        int result = userMapper.insert(user);
//        System.out.println("result = " + result);
//        System.out.println("MybatisplusApplicationTests.testInsert");
//
//
//    }

    @Test
    void testService(){
        long count = userService.count();
        System.out.println("count = " + count);
    }


    //如果
    @Test
    void testSave(){
        User user = new User();
        user.setEmail("123@qq.com");
        user.setAge(20);
        user.setName("set设置");
        user.setId(600L);
        boolean save = userService.save(user);
        System.out.println("save = " + save);


    }

    @Test
    void testDelete(){
        boolean b = userService.removeById(1);
        System.out.println("b = " + b);
    }

    @Test
    void testWrapper(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name","j").isNotNull("email").between("age",15,20);
        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println("users = " + users);
    }


    @Test
    void testLamdaWrapper(){
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();

        userQueryWrapper.like(User::getName,"j").isNotNull(User::getEmail).between(User::getAge,15,20);
        List<User> users = userMapper.selectList(userQueryWrapper);

        System.out.println("users = " + users);
    }

    @Test
    void testPageVO(){
        Page<User> page= new Page<>(1,10);
        //自定义的不会帮你加上@TableLogic 的is_deleted逻辑删除的操作,估计@version的也一样
//        Page<User> userPage = userMapper.seletePageVO(page, 17);
//
//        List<User> records = page.getRecords();
//        System.out.println("records = " + records);
       userMapper.selectPage(page, null);
        List<User> records = page.getRecords();
        records.forEach(System.out::println);

    }

    @Test
    void testInsert(){
        User user = new User();
        user.setAge(20);
        user.setName("ENUM");
        user.setSex(SexEnums.MALE);
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }
}
