package com.yydone.test;

import com.yydone.demo.Application;
import com.yydone.demo.dal.mapper.UserMapper;
import com.yydone.demo.dal.model.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void getByUserId() {
        String userId = "1000101";
        UserDO userDO = userMapper.selectByUserId(userId);
        Assert.assertNotNull(userDO);
        Assert.assertEquals("user01", userDO.getUserName());
        userId = "1000102";
        userDO = userMapper.selectByUserId(userId);
        Assert.assertNotNull(userDO);
        Assert.assertEquals("user02", userDO.getUserName());
    }
}
