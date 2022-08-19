package com.example.ddd.acl.port.user;

import com.example.ddd.acl.port.repository.user.po.userPO;
import com.example.ddd.acl.port.repository.user.po.userAccountPO;
import com.example.ddd.acl.port.repository.user.po.userAddressPO;
import com.example.ddd.acl.port.repository.user.userRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.annotation.Resource;
import java.util.Arrays;



@Slf4j
@RunWith(Parameterized.class)
public class userRepositoryTests {

    @Parameterized.Parameters(name="{index} should_{0}_{1}")
    public static Object[][] data()
    {
        return new Object[][]{
                {1, true},
                {2, true}
        };

    }

    Integer input;
    boolean expect;
    public userRepositoryTests(Integer input,boolean expect)
    {
        this.input=input;
        this.expect=expect;
    }


    @Resource
    userRepository userRepository;

    @BeforeAll
    public static  void init()
    {
        log.debug("init");

    }

    @AfterAll
    public static void destore()
    {        log.debug("destore");


    }


    @BeforeEach
    public void before()
    {
        log.debug("before");

    }


    @AfterEach
    public void after()
    {
        log.debug("after");

    }



    @Test
    public void insert() {

        userPO user = new userPO();
        user.setName("郭明");
        user.setEmail("guoming@qq.com");
        user.setTelephone("1868894164");
        user.setStatus(1);
        user.setAge(18);
        user.setAddress(new userAddressPO(user.getUserId(),"嘻嘻嘻街道","广东","深圳","南山"));

        user.setAccounts(Arrays.asList(
                new userAccountPO(user.getUserId(), "guoming","123456"),
                new userAccountPO(user.getUserId(),"18688941654","123456")));
        userRepository.insert(user);

    }



    @Test
    public void update() {

    }

    @Test
   public void selectById() {
    }

    @Test
   public void deleteById() {
    }
}