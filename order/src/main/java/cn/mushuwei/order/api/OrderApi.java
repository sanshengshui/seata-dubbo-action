package cn.mushuwei.order.api;

import cn.mushuwei.order.api.dto.OrderDTO;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:57 下午
 */
public interface OrderApi {

    /**
     * 创建订单
     *
     * @param orderDTO 订单信息
     * @return 是/否
     */
    Boolean createOrder(OrderDTO orderDTO);
}
