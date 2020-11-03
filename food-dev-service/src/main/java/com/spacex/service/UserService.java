package com.spacex.service;

import com.spacex.pojo.Users;
import com.spacex.pojo.bo.UserBO;

public interface UserService {
    /**
     * 判断用户名是否存在
     */
    public boolean queryUsernameIsExist(String username);
    /**
     * 注册用户
     */
    public Users CreateUser(UserBO useBO);

    /**
     * 检索用户名和密码是否匹配--登陆
     */

    public Users queryUserForLogin(String username,String password);
}
