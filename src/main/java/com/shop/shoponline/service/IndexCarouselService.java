package com.shop.shoponline.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.entity.IndexCarousel;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyc
 * @since 2023-11-08
 */
public interface IndexCarouselService extends IService<IndexCarousel> {
    List<IndexCarousel> getList(Integer distributionSite);

}
