package cn.mushuwei.order.provider;

import cn.mushuwei.account.api.AccountApi;
import cn.mushuwei.account.api.dto.AccountDTO;
import cn.mushuwei.order.api.OrderApi;
import cn.mushuwei.order.api.dto.OrderDTO;
import cn.mushuwei.order.service.OrderService;
import com.alibaba.fastjson.JSON;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    @DubboReference
    private AccountApi accountApi;

    @Override
    public Boolean createOrderPrepare(BusinessActionContext actionContext, OrderDTO orderDTO) {
        log.info("orderDTO: {}, actionContext: {}",orderDTO, actionContext);
        try {
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setUserId(orderDTO.getUserId());
            accountDTO.setAmount(orderDTO.getOrderAmount());
            Boolean accountResult =  accountApi.decreaseAccountPrepare(null, accountDTO);

            OrderDTO orderResult = orderService.createOrderPrepare(orderDTO);
            log.info("orderResult: {}", orderResult);
            OrderDTO result = JSON.parseObject(JSON.toJSONString(actionContext.getActionContext("orderDTO")), OrderDTO.class);
            result.setOrderNo(orderResult.getOrderNo());
            Map<String, Object> resultOrder = new HashMap<>();
            resultOrder.put("orderDTO", orderDTO);
            actionContext.setActionContext(resultOrder);

            if (!accountResult || Objects.isNull(orderResult)) {
                throw new RuntimeException("失败");
            }
            return true;
        } catch (Exception e) {
            log.info("服务调用异常, orderDTO: {}, actionContext: {}", orderDTO, actionContext);
        }
        return false;
    }

    @Override
    public Boolean createOrderCommit(BusinessActionContext actionContext) {
        OrderDTO orderDTO = JSON.parseObject(JSON.toJSONString(actionContext.getActionContext("orderDTO")), OrderDTO.class);
        try {
            log.info("orderDTO 提交阶段: {}", orderDTO);
            Boolean result = orderService.createOrderCommit(orderDTO);
            if (!result) {
                throw new RuntimeException("失败");
            }
            return true;
        } catch (Exception e) {
            log.info("服务调用异常, orderDTO: {}, actionContext: {}", orderDTO, actionContext);
        }
        return false;
    }

    @Override
    public Boolean createOrderCancel(BusinessActionContext actionContext) {
        OrderDTO orderDTO = JSON.parseObject(JSON.toJSONString(actionContext.getActionContext("orderDTO")), OrderDTO.class);
        try {
            Boolean result = orderService.createOrderCancel(orderDTO);
            if (!result) {
                throw new RuntimeException("失败");
            }
            return true;
        } catch (Exception e) {
            log.info("服务调用异常, orderDTO: {}, actionContext: {}", orderDTO, actionContext);
        }
        return false;
    }

}
