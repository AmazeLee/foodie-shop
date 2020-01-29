package com.sh.pojo.bo;

/**
 * @ClassName  UserBO
 * @Description
 * @Author  leeshuhua
 * @Date    2020/1/5 23:14
 * @Version V1.0
 **/
public class UserBO {

    private String userName;

    private String password;

    private String confirmPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
