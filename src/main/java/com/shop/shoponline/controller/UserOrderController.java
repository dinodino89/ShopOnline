package com.shop.shoponline.controller;

import com.shop.shoponline.service.UserOrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyc
 * @since 2023-11-08
 */
@Tag(name = "订单管理")
@RestController
@AllArgsConstructor
@RequestMapping("/shoponline/userOrder")
public class UserOrderController {
    private final UserOrderService userOrderService;

    @Operation(summary="提交订单")
    @PostMapping("submit")
    public Result<JSONObject> saveUserOrder(@RequestBody @Validated UserOrderVO userOrderVO, HttpServletRequest request) {
        userOrderVO.setUserId(getUserId(request));
        Integer orderId = userOrderService.addGoodsOrder(userOrderVO);
        JSONObject json = new JSONObject();
        json.put("id", orderId);
        return Result.ok(json);


}
