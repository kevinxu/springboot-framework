package com.example.demo.service;
/*
* 4. 编写业务层接口
 */

import com.example.demo.domain.User;

import java.util.List;

public interface IUserService {

    public void insert(User user);

    public void update(User user);

    public User find(int id);

    public void delete(int id);

    public List<User> findByName(String name);
}
