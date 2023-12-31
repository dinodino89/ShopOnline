package com.shop.shoponline.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shoponline.vo.CategoryChildrenGoodsVO;
import com.shop.shoponline.vo.CategoryVO;
import com.shop.shoponline.vo.RecommendGoodsVO;
import com.shop.shoponline.convert.GoodsConvert;
import com.shop.shoponline.entity.Category;
import com.shop.shoponline.entity.Goods;
import com.shop.shoponline.enums.CategoryRecommendEnum;
import com.shop.shoponline.mapper.CategoryMapper;
import com.shop.shoponline.mapper.GoodsMapper;
import com.shop.shoponline.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyc
 * @since 2023-11-09
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    private final GoodsMapper goodsMapper;
    @Override
    public List<Category> getIndexCategoryList() {
        LambdaQueryWrapper<Category> wrapper=new LambdaQueryWrapper<>();
        //查询首页和分类都推荐的分类以及首页推荐的分类
        wrapper.eq(Category::getIsRecommend, CategoryRecommendEnum.ALL_RECOMMEND.getValue()).or().eq(Category::getIsRecommend, CategoryRecommendEnum.CATEGORY_HOME_RECOMMEND.getValue());
        wrapper.orderByDesc(Category::getCreateTime);
        List<Category> list=baseMapper.selectList(wrapper);
        return list;
    }

    @Override
    public List<CategoryVO> getCategoryList() {
        List<CategoryVO> list=new ArrayList<>();
        //1.
        LambdaQueryWrapper<Category> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Category::getIsRecommend,
                CategoryRecommendEnum.ALL_RECOMMEND.getValue()).or().eq(Category::getIsRecommend,
                CategoryRecommendEnum.CATEGORY_HOME_RECOMMEND.getValue());
        List<Category> categories=baseMapper.selectList(wrapper);
        //2.
        LambdaQueryWrapper<Goods> queryWrapper=new LambdaQueryWrapper<Goods>();
        for(Category category: categories){
            CategoryVO categoryVO=new CategoryVO();
            categoryVO.setId(category.getId());
            categoryVO.setName(category.getName());
            categoryVO.setIcon(category.getIcon());
            wrapper.clear();
            wrapper.eq(Category::getParentId,category.getId());
            List<Category> childCategories=baseMapper.selectList(wrapper);
            List<CategoryChildrenGoodsVO> categoryChildrenGoodsList=new ArrayList<>();
            //3.
            for(Category item:childCategories){
                CategoryChildrenGoodsVO childrenGoodsVO=new CategoryChildrenGoodsVO();
                childrenGoodsVO.setId(item.getId());
                childrenGoodsVO.setName(item.getName());
                childrenGoodsVO.setIcon(item.getIcon());
                childrenGoodsVO.setParentId(category.getId());
                childrenGoodsVO.setParentName(category.getName());
                queryWrapper.clear();
                List<Goods> goodsList=goodsMapper.selectList(queryWrapper.eq(Goods::getCategoryId,item.getId()));
                List<RecommendGoodsVO> goodsVOList= GoodsConvert.INSTANCE.convertToRecommendGoodsVOList(goodsList);
                childrenGoodsVO.setGoods(goodsVOList);
                categoryChildrenGoodsList.add(childrenGoodsVO);
            }
            categoryVO.setChildren(categoryChildrenGoodsList);
            list.add(categoryVO);
        }
        return  list;
    }
}
