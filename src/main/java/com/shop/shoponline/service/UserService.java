package com.shop.shoponline.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.entity.User;
import com.shop.shoponline.query.UserLoginQuery;
import com.shop.shoponline.vo.LoginResultVO;
import com.shop.shoponline.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyc
 * @since 2023-11-08
 */
public interface UserService extends IService<User> {
     LoginResultVO login(UserLoginQuery query);
     User getUserInfo(Integer userId);
     UserVO editUserInfo(UserVO userVO);
     String editUserAvatar(Integer userId, MultipartFile file);
}
