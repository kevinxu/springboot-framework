package com.example.demo.controller;
/*
* 6. 编写前端控制器类
* @RestController 标识这个类，返回的结果为Json字符串。
* @RestController注解，相当于@Controller+@ResponseBody两个注解的结合，返回json数据不需要在方法前面加@ResponseBody注解了，
* 但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
* 如果需要返回数据到jsp或者html页面，则使用@Controller注解。这里推荐使用@Controller注解，因为需要直接返回数据的时候可以增加@ResponseBody注解
* @ComponentScan({"com.example.demo.service"}) ：标识业务层的类，用来找到业务层对象，com.example.demo.service是业务类的路径
* @MapperScan("com.example.demo.mapper") ：标识持久层mapper接口，用来找到mapper对象，com.example.demo.mapper是接口的路径
* 这三个注解都不能少！！！ 少了SpringBoot就无法正常启动了！！
 */

import com.example.demo.domain.User;
import com.example.demo.pojo.ApiResponse;
import com.example.demo.service.IUserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ComponentScan({"com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/users/{id}")
    public ApiResponse findUserById(@PathVariable int id) {
        User user = userService.find(id);
        if (user == null) {
            return  new ApiResponse<String>(9999, "用户名不存在", null);
        }

        return new ApiResponse<>(0, "success", user);
    }

    @RequestMapping("/users")
    public ApiResponse
    findUserByName(@RequestParam(name = "name") String name) {

        List<User> userList = userService.findByName(name);
        if (userList.isEmpty()) {
            System.out.println("User name not exist.");
        }

        return new ApiResponse<>(0, "success", userList);
    }
}
