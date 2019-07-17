package com.example.demo.mapper;
/*
* 2. 编写持久层接口：即DAO层接口，定义操作数据库的方法，  这里切记要用@Mapper注解标识
 */
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public void insert(User user);

    public void update(User user);

    public void delete(int id);

    public User find(int id);

    public List<User> findByName(String name);
}
