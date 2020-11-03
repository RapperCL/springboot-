package com.spacex.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//用户对象
@ApiModel(value="用户对象")
public class UserBO {
    @ApiModelProperty(value="用户名",required = true)
    private String username;

    @ApiModelProperty(value="密码",required = true)
    private String password;

    @ApiModelProperty(value="确认密码",required = false)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
