package com.sangeng;


import com.sangeng.domain.User;
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
        String encode1 = bCryptPasswordEncoder.encode("1234");
        System.out.println(encode);
        System.out.println(encode1);

        //$2a$10$x1yW0KrYII.dwbYa.xL16ewVwuUF.Mqi.59ZvAMlNj8eyR9L/OGiu
        //$2a$10$nl0dOJ4BvvbFKDXCD5Pqc.1N7nJ66MWpSxIVfxxdpNhKiYxKhEn3y
        System.out.println(bCryptPasswordEncoder.matches("1234", "$2a$10$x1yW0KrYII.dwbYa.xL16ewVwuUF.Mqi.59ZvAMlNj8eyR9L/OGiu"));
    }

    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
