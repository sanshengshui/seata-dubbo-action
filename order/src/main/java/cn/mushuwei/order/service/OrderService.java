package cn.mushuwei.order.service;

import cn.mushuwei.order.api.dto.OrderDTO;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:56 下午
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO - 订单信息
     * @return
     */
    Boolean createOrder(OrderDTO orderDTO);
}
