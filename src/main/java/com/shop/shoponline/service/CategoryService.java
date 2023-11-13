package com.shop.shoponline.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.entity.Category;
import com.shop.shoponline.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyc
 * @since 2023-11-08
 */
public interface CategoryService extends IService<Category> {
    List<Category> getIndexCategoryList();
    List<CategoryVO> getCategoryList();
}
