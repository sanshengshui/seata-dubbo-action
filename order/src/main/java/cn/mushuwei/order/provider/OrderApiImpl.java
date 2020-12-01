package cn.mushuwei.order.provider;

import cn.mushuwei.order.api.OrderApi;
import cn.mushuwei.order.api.dto.OrderDTO;
import cn.mushuwei.order.service.OrderService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jamesmsw
 * @date 2020/12/1 6:00 下午
 */
@DubboService
@Component
@Slf4j
public class OrderApiImpl implements OrderApi {

    @Resource(name = "orderService")
    private OrderService orderService;

    @Override
    public Boolean createOrder(OrderDTO orderDTO) {
       log.info("order-全局事务id :" + RootContext.getXID());
        try {
            Boolean result = orderService.createOrder(orderDTO);
            if (result) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.info("服务调用异常, orderDTO: {}", orderDTO);
        }
        return false;
    }

}
