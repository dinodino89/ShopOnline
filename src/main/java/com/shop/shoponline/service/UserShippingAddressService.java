package com.shop.shoponline.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.entity.UserShippingAddress;
import com.shop.shoponline.vo.AddressVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyc
 * @since 2023-11-08
 */
public interface UserShippingAddressService extends IService<UserShippingAddress> {
   Integer saveShippingAddress(AddressVO addressVO);
   Integer editShippingAddress(AddressVO addressVO);
   List<AddressVO> getList(Integer userId);
   AddressVO getAddressInfo(Integer id);
   void removeShippingAddress(Integer id);
}
