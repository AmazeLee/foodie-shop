package com.sh.service;

import com.sh.pojo.Carousel;

import java.util.List;

/**
 * @ClassName CarouselService
 * @Desc
 * @Author leeshuhua
 * @Date 2020/1/31 22:05
 * @Version V1.0
 **/
public interface CarouselService {

    /**
     * 查询所有轮播图列表
     *
     * @param isShow
     * @return
     */
    public List<Carousel> queryAll(Integer isShow);
}
