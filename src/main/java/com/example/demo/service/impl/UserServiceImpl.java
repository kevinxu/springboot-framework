package com.example.demo.service.impl;
/*
* 5. 编写业务层接口的实现类，数据接口实现层添加@Service注解就可以了，接口层不用添加注解。
* 如果实现层不添加注解，main方法启动的时候报错。
 */


import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@ComponentScan({"com.example.demo.mapper"})
@Service("userService") // 这里必须要有Service注解，不然Controller层Autowired装配失败
public class UserServiceImpl implements IUserService {

    @Resource //这里没有Resource注解的话bean装配会失败
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User find(int id) {
        return userMapper.find(id);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }
}
