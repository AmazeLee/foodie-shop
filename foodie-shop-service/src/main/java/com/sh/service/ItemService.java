package com.sh.service;

import com.sh.pojo.Items;
import com.sh.pojo.ItemsImg;
import com.sh.pojo.ItemsParam;
import com.sh.pojo.ItemsSpec;
import com.sh.pojo.vo.CommentLevelCountsVO;
import com.sh.utils.PagedGridResult;

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


    /**
     * 根据商品id查询商品的评价等级数量
     * @param itemId
     */
    public CommentLevelCountsVO queryCommentCounts(String itemId);


    /**
     * 根据商品id查询商品的评价（分页）
     *
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);


    /**
     * 搜索商品列表
     *
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);

    /**
     * 根据分类id搜索商品列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searhItems(Integer catId, String sort,
                                      Integer page, Integer pageSize);

}
