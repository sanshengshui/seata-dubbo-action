package cn.mushuwei.business.service.impl;

import cn.mushuwei.business.dto.BusinessDTO;
import cn.mushuwei.business.service.BusinessService;
import cn.mushuwei.order.api.OrderApi;
import cn.mushuwei.order.api.dto.OrderDTO;
import cn.mushuwei.storage.api.StorageApi;
import cn.mushuwei.storage.api.dto.CommodityDTO;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:37 下午
 */
@Slf4j
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

    @DubboReference
    private StorageApi storageApi;

    @DubboReference
    private OrderApi orderApi;

    private boolean flag;

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "seata-demo-business")
    public Boolean handleBusiness(BusinessDTO businessDTO) {
        flag = true;
        log.info("开始全局事务，XID = " + RootContext.getXID());
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityCode(businessDTO.getCommodityCode());
        commodityDTO.setCount(businessDTO.getCount());
        boolean storageResult =  storageApi.decreaseStoragePrepare(null, commodityDTO);

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        boolean orderResult = orderApi.createOrderPrepare(null, orderDTO);

        //打开注释测试事务发生异常后，全局回滚功能
//        if (!flag) {
//            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
//        }

        if (!storageResult || !orderResult) {
            throw new RuntimeException("失败");
        }
        return true;
    }
}
