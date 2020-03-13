package com.sh.service;

import com.sh.pojo.Items;
import com.sh.pojo.ItemsImg;
import com.sh.pojo.ItemsParam;
import com.sh.pojo.ItemsSpec;

import java.util.List;

/**
 * @ClassName ItemService
 * @Desc
 * @Author leeshuhua
 * @Date 2020/3/13 22:07
 * @Version V1.0
 **/
public interface ItemService {

    /**
     * 根据商品ID查询详情
     *
     * @param itemId
     * @return
     */
    public Items queryItemById(String itemId);

    /**
     * 根据商品ID查询商品图片列表
     *
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品ID查询商品规格
     *
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品ID查询商品参数
     *
     * @param itemId
     * @return
     */
    public ItemsParam queryItemParam(String itemId);
}
