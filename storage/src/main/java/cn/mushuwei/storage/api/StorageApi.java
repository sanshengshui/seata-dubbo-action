package cn.mushuwei.storage.api;

import cn.mushuwei.storage.api.dto.CommodityDTO;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:37 上午
 */
@LocalTCC
public interface StorageApi {


    /**
     * 扣减库存准备
     *
     * @param actionContext 业务动作上下文
     * @param commodityDTO 库存信息
     * @return 是/否
     */
    @TwoPhaseBusinessAction(name = "decreaseStorageTcc", commitMethod = "decreaseStorageCommit", rollbackMethod = "decreaseStorageCancel")
    Boolean decreaseStoragePrepare(BusinessActionContext actionContext,
                                   @BusinessActionContextParameter(paramName = "commdityDTO") CommodityDTO commodityDTO);

    /**
     * 扣减库存提交
     *
     * @param actionContext 业务动作上下文
     * @return 是/否
     */
    Boolean decreaseStorageCommit(BusinessActionContext actionContext);

    /**
     * 扣减库存回滚
     *
     * @param actionContext 业务动作上下文
     * @return 是/否
     */
    Boolean decreaseStorageCancel(BusinessActionContext actionContext);
}
