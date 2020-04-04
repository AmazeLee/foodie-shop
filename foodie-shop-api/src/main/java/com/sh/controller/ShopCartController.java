package com.sh.controller;

import com.sh.pojo.bo.ShopcartBO;
import com.sh.utils.MyJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ShopCartController
 * @Desc
 * @Author leeshuhua
 * @Date 2020/4/4 19:03
 * @Version V1.0
 **/
@Api(value = "购物车接口",tags = {"购物车相关接口"})
@RestController
@RequestMapping("shopcart")
public class ShopCartController {


    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/add")
    public MyJSONResult add(
            @RequestParam String userId,
            @RequestBody ShopcartBO shopcartBO,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        if (StringUtils.isBlank(userId)) {
            return MyJSONResult.errorMsg("");
        }

        System.out.println(shopcartBO);

        // TODO 前端用户在登录的情况下，添加商品到购物车，会同时在后端同步购物车到redis缓存

        return MyJSONResult.ok();
    }
}
