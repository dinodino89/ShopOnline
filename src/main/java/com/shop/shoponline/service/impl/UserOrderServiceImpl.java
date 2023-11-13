package com.shop.shoponline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shoponline.entity.UserOrder;
import com.shop.shoponline.mapper.UserOrderMapper;
import com.shop.shoponline.service.UserOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyc
 * @since 2023-11-09
 */
@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {

}
