package com.sh.controller;

import com.sh.pojo.Users;
import com.sh.pojo.bo.UserBO;
import com.sh.service.UserService;
import com.sh.utils.CookieUtils;
import com.sh.utils.JsonUtils;
import com.sh.utils.MD5Utils;
import com.sh.utils.MyJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author lee
 * @Description
 * @Date 2019/12/7 23:19
 **/
@Api(value = "注册登录",tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户名是否存在",notes = "用户名是否存在",httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public MyJSONResult usernameIsExist(@RequestParam String username){

        if(StringUtils.isBlank(username)){

            return MyJSONResult.errorMsg("用户名不能为空");
        }

        boolean isExist = userService.queryUsernameIsExist(username);

        if(isExist){

            return MyJSONResult.errorMsg("用户名已经存在");
        }

        return MyJSONResult.ok();
    }

    @ApiOperation(value = "注册用户",notes = "注册用户",httpMethod = "GET")
    @PostMapping("/regist")
    public MyJSONResult register(@RequestBody UserBO userBO) throws Exception {

        String userName = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        // 判断用户名或者密码都不为空
        if(StringUtils.isBlank(userName)|| StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)){
            return MyJSONResult.errorMsg("用户名或者密码不能为空");
        }
        // 查询用户名是否为空
        boolean isExist = userService.queryUsernameIsExist(userName);

        if(isExist){

            return MyJSONResult.errorMsg("用户名已经存在");
        }
        // 密码长度不能少于6位
        if(password.length() < 6){

            return MyJSONResult.errorMsg("密码长度不能少于6位");
        }
        // 判断两次密码是否一致
        if(!password.equals(confirmPassword)){

            return MyJSONResult.errorMsg("两次密码输入不一致");
        }

        // 实现注册
        userService.createUser(userBO);

        return MyJSONResult.ok();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public MyJSONResult login(@RequestBody UserBO userBO,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        String username = userBO.getUsername();
        String password = userBO.getPassword();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password)) {
            return MyJSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 实现登录
        Users userResult = userService.queryUserForLogin(username,
                MD5Utils.getMD5Str(password));

        if (userResult == null) {
            return MyJSONResult.errorMsg("用户名或密码不正确");
        }

        userResult = setNullProperty(userResult);

        // 设置COOKIE
        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);


        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据

        return MyJSONResult.ok(userResult);
    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }

}
