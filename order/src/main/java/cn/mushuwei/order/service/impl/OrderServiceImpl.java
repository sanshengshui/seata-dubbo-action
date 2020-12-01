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
    private OrderDao orderDao;
    @DubboReference
    private AccountApi accountApi;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createOrder(OrderDTO orderDTO) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountDTO.setAmount(orderDTO.getOrderAmount());
        boolean result = accountApi.decreaseAccount(accountDTO);
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        OrderDO order = PojoUtils.copyProperties(orderDTO, OrderDO.class);
        order.setCount(orderDTO.getOrderCount());
        order.setAmount(orderDTO.getOrderAmount().doubleValue());
        try {
            orderDao.createOrder(order);
        } catch (Exception e) {
            log.info("创建订单失败: {}", order, e);
        }
        return true;
    }
}
