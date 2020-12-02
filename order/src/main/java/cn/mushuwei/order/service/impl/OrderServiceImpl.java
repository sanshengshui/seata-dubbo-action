package cn.mushuwei.order.service.impl;

import cn.mushuwei.account.api.AccountApi;
import cn.mushuwei.account.api.dto.AccountDTO;
import cn.mushuwei.order.api.dto.OrderDTO;
import cn.mushuwei.order.dao.OrderDao;
import cn.mushuwei.order.entity.OrderDO;
import cn.mushuwei.order.service.OrderService;
import cn.mushuwei.order.utils.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author jamesmsw
 * @date 2020/12/1 6:05 下午
 */
@Service("orderService")
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource(name = "orderDao")
    private OrderDao orderDAO;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO createOrderPrepare(OrderDTO orderDTO) {
        //TODO 传递问题
        //orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        OrderDO order = PojoUtils.copyProperties(orderDTO, OrderDO.class);
        order.setCount(orderDTO.getOrderCount());
        order.setAmount(orderDTO.getOrderAmount().doubleValue());
        order.setCode(orderDTO.getCommodityCode());
        order.setStatus(1);
        try {
            orderDAO.tccCreateOrderPrepare(order);
        } catch (Exception e) {
            log.info("创建订单失败: {}", order, e);
        }
        orderDTO.setOrderNo(orderDTO.getOrderNo());

        return orderDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createOrderCommit(OrderDTO orderDTO) {
        int order = orderDAO.tccCreateOrderCommitOrCancel(2, orderDTO.getOrderNo());
        if (order > 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createOrderCancel(OrderDTO orderDTO) {
        log.info("orderDTO: {}", orderDTO);
        int order = orderDAO.tccCreateOrderCommitOrCancel(3, orderDTO.getOrderNo());
        if (order > 0) {
            return true;
        }
        return false;
    }
}
