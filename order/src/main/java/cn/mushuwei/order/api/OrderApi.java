package cn.mushuwei.order.api;

import cn.mushuwei.order.api.dto.OrderDTO;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:57 下午
 */
@LocalTCC
public interface OrderApi {


    /**
     * 创建订单准备
     *
     * @param orderDTO
     * @param actionContext 业务动作上下文
     * @return
     */
    @TwoPhaseBusinessAction(name = "createOrderTcc", commitMethod = "createOrderCommit", rollbackMethod = "createOrderCancel")
    Boolean createOrderPrepare(BusinessActionContext actionContext,
                               @BusinessActionContextParameter(paramName = "orderDTO") OrderDTO orderDTO);

    /**
     * 创建订单提交
     *
     * @param actionContext 业务动作上下文
     * @return
     */
    Boolean createOrderCommit(BusinessActionContext actionContext);

    /**
     * 创建订单取消
     *
     * @param actionContext 业务动作上下文
     * @return
     */
    Boolean createOrderCancel(BusinessActionContext actionContext);
}
