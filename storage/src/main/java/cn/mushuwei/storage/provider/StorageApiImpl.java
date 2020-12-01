package cn.mushuwei.storage.provider;

import cn.mushuwei.storage.api.StorageApi;
import cn.mushuwei.storage.api.dto.CommodityDTO;
import cn.mushuwei.storage.service.StorageService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:51 上午
 */
@DubboService
@Component
@Slf4j
public class StorageApiImpl implements StorageApi {

    @Resource(name = "storageService")
    private StorageService storageService;

    @Override
    public Boolean decreaseStorage(CommodityDTO commodityDTO) {
        log.info("storage-全局事务，XID = " + RootContext.getXID());
        try {
            Boolean result = storageService.decreaseStorage(commodityDTO);
            if (result) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.info("服务调用异常, commodityDTO: {}", commodityDTO);
        }
        return false;
    }
}
