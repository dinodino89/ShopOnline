package com.shop.shoponline.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.common.result.PageResult;
import com.shop.shoponline.entity.Goods;
import com.shop.shoponline.query.Query;
import com.shop.shoponline.query.RecommendByTabGoodsQuery;
import com.shop.shoponline.vo.GoodsVO;
import com.shop.shoponline.vo.IndexTabRecommendVO;
import com.shop.shoponline.vo.RecommendGoodsVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyc
 * @since 2023-11-08
 */
public interface GoodsService extends IService<Goods> {
    IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query);
    PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query);
    GoodsVO getGoodsDetail(Integer id);
}
