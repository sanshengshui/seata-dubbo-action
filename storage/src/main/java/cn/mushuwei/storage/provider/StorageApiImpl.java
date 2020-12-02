package cn.mushuwei.storage.provider;

import cn.mushuwei.storage.api.StorageApi;
import cn.mushuwei.storage.api.dto.CommodityDTO;
import cn.mushuwei.storage.service.StorageService;
import com.alibaba.fastjson.JSON;
import io.seata.rm.tcc.api.BusinessActionContext;
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
    public Boolean decreaseStoragePrepare(BusinessActionContext actionContext, CommodityDTO commodityDTO) {
        log.info("commodityDTO: {}, actionContext: {}",commodityDTO, actionContext);
        try {
            Boolean result = storageService.decreaseStoragePrepare(commodityDTO);
            if (!result) {
                return false;
            }
            return true;
        } catch (Exception e) {
            log.info("服务调用异常, commodityDTO: {}, actionContext: {}", commodityDTO, actionContext);
        }
        return false;
    }

    @Override
    public Boolean decreaseStorageCommit(BusinessActionContext actionContext) {
        CommodityDTO commodityDTO = JSON.parseObject(JSON.toJSONString(actionContext.getActionContext("commdityDTO")), CommodityDTO.class);
        try {
            Boolean result = storageService.decreaseStorageCommit(commodityDTO);
            if (!result) {
                return false;
            }
            return true;
        } catch (Exception e) {
            log.info("服务调用异常, commodityDTO: {}, actionContext: {}", commodityDTO, actionContext);
        }
        return false;
    }

    @Override
    public Boolean decreaseStorageCancel(BusinessActionContext actionContext) {
        CommodityDTO commodityDTO = JSON.parseObject(JSON.toJSONString(actionContext.getActionContext("commdityDTO")), CommodityDTO.class);
        try {
            Boolean result = storageService.decreaseStorageCancel(commodityDTO);
            if (!result) {
                return false;
            }
            return true;
        } catch (Exception e) {
            log.info("服务调用异常, commodityDTO: {}, actionContext: {}", commodityDTO, actionContext);
        }
        return false;
    }
}
