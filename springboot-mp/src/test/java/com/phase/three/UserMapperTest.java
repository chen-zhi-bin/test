package com.phase.three;

import com.phase.three.mapper.UserMapper;
import com.phase.three.pojo.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void listAll(){
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }
}
