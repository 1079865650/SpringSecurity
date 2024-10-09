package com.sangeng;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sangeng.domain.User;
import com.sangeng.mapper.MenuMapper;
import com.sangeng.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void TestBCryptPasswordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("1234");
        String encode1 = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);
        System.out.println(encode1);
        System.out.println(bCryptPasswordEncoder.matches("1234", "c"));
        //$2a$10$x1yW0KrYII.dwbYa.xL16ewVwuUF.Mqi.59ZvAMlNj8eyR9L/OGiu
        //$2a$10$nl0dOJ4BvvbFKDXCD5Pqc.1N7nJ66MWpSxIVfxxdpNhKiYxKhEn3y
        System.out.println(bCryptPasswordEncoder.matches("123456", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwMGNlNjNlMjJiMjQ0ODgxYjI2ODBlYjNkZTdjM2E5OSIsInN1YiI6IjEyMzQ1NiIsImlzcyI6InNnIiwiaWF0IjoxNzI3NzA5MjI5LCJleHAiOjE3Mjc3MTI4Mjl9._T0pLuBYtm0amEMqWtpj63J4DjC7o3tashK9u_NRNIo"));
    }

    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
//        String a = null;
//        System.out.println(a.isEmpty());
//        String bb = "";
//        System.out.println(bb.isEmpty());
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, "test");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Autowired
    private MenuMapper menuMapper;
    @Test
    public void testSelectPermsByUserId(){
        List<String> strings = menuMapper.selectPermsByUserId(2L);
        System.out.println(strings);
    }
}
