package cn.mushuwei.order.service;

import cn.mushuwei.order.api.dto.OrderDTO;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:56 下午
 */
public interface OrderService {

    /**
     * 创建订单准备
     *
     * @param orderDTO
     * @return
     */
    OrderDTO createOrderPrepare(OrderDTO orderDTO);

    /**
     * 创建订单准备
     *
     * @param orderDTO
     * @return
     */
    Boolean createOrderCommit(OrderDTO orderDTO);

    /**
     * 创建订单准备
     *
     * @param orderDTO
     * @return
     */
    Boolean createOrderCancel(OrderDTO orderDTO);
}
