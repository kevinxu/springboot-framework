package com.example.demo.controller;

import com.example.demo.annotation.UserTokenCheck;
import com.example.demo.pojo.ApiResponse;
import com.example.demo.dto.UserRequestDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ApiResponse<String> helloWorld() {
        return  new ApiResponse<String>(9999, "OK", "Hello World: 你好，Kevin");
    }

    //测试全局的异常处理
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public ApiResponse testExceptionHandle() {
        int i = 10/0;
        return new ApiResponse<String>(9999, "OK", null);
    }


    //测试hibernate-validator验证
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ApiResponse addUser(@RequestBody @Valid UserRequestDTO requestDTO) {
        System.out.println(requestDTO);
        return new ApiResponse<>(9999, "添加用户成功", requestDTO);
    }

    //测试Token验证功能
    @UserTokenCheck //在需要验证token的方法上添加此注解
    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public ApiResponse<String> checkToken() {
        return new ApiResponse<String>(9999, "OK", null);
    }
}
