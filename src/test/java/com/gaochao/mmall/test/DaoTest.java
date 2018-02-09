package com.gaochao.mmall.test;

import com.gaochao.mmall.dao.CategoryMapper;
import com.gaochao.mmall.dao.UserMapper;
import com.gaochao.mmall.pojo.Category;
import com.gaochao.mmall.pojo.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by gaochao on 2018/2/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager")
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class DaoTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private UserMapper userMapper;


    @Test
    public void getCategoryChild() {
        Category d = categoryMapper.selectByPrimaryKey(100027);
        System.out.println(d);
        Category d4 = categoryMapper.selectByPrimaryKey(4);
        System.out.println(d4);
    }

    @Test
    public void getUserById() {
        User user = userMapper.selectByPrimaryKey(13);
        System.out.println(user);
    }
}
