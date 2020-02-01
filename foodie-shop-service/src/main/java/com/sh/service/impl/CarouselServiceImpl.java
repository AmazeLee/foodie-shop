package com.sh.service.impl;

import com.sh.mapper.CarouselMapper;
import com.sh.pojo.Carousel;
import com.sh.service.CarouselService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CarouselServiceImpl
 * @Desc
 * @Author leeshuhua
 * @Date 2020/1/31 22:05
 * @Version V1.0
 **/
@Service
public class CarouselServiceImpl  implements CarouselService {

    @Resource
    private CarouselMapper carouselMapper;

    /**
     * 查询所有轮播图列表
     *
     * @param isShow
     * @return
     */
    @Override
    public List<Carousel> queryAll(Integer isShow) {

        Example example = new Example(Carousel.class);
        example.orderBy("sort").asc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow",isShow);

        List<Carousel> result = carouselMapper.selectByExample(example);

        return result;
    }
}
