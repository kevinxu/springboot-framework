package com.example.demo.dto;
/*
*  数据传输类
* */
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequestDTO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotNull
    @Size(min = 5, max = 10, message = "密码必须在5-10位之间")
    private String pwd;

    @Range(min = 0, max = 120, message = "年龄不能为负数且不能超过120岁")
    private Integer age;

    @Pattern(regexp = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$", message = "请输入正确的邮箱地址")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
