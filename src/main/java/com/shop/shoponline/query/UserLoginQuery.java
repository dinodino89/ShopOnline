package com.shop.shoponline.query;

import com.shop.shoponline.vo.LoginResultVO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginQuery {
    @NotBlank(message = "code不能为空")
    private String code;

}
