package com.sh.service;

import com.sh.pojo.Users;
import com.sh.pojo.bo.UserBO;

/**
 * @Author lee
 * @Description
 * @Date 2019/12/7 22:14
 **/
public interface UserService {

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     * @param userBO
     * @return
     */
    public Users createUser(UserBO userBO) throws Exception;
}
