package com.sh.controller;

import com.sh.enums.YesOrNo;
import com.sh.pojo.Carousel;
import com.sh.service.CarouselService;
import com.sh.utils.MyJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName indexController
 * @Desc
 * @Author leeshuhua
 * @Date 2020/2/1 15:29
 * @Version V1.0
 **/
@Api(value = "首页",tags = {"用于首页的相关接口"})
@RestController
@RequestMapping("index")
public class indexController {

    @Resource
    private CarouselService carouselService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public MyJSONResult carousel() {
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        return MyJSONResult.ok(list);
    }
}
