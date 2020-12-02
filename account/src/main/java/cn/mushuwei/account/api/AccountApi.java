package cn.mushuwei.account.api;

import cn.mushuwei.account.api.dto.AccountDTO;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:20 下午
 */
@LocalTCC
public interface AccountApi {


    /**
     * 从账号扣钱准备
     *
     * @param accountDTO
     * @param actionContext 业务动作上下文
     * @return 是/否
     */
    @TwoPhaseBusinessAction(name = "decreaseAccountTcc", commitMethod = "decreaseAccountCommit", rollbackMethod = "decreaseAccountCancel")
    Boolean decreaseAccountPrepare(BusinessActionContext actionContext,
                                   @BusinessActionContextParameter(paramName = "accountDTO") AccountDTO accountDTO);

    /**
     * 从账号扣钱提交
     *
     * @param actionContext
     * @return 是/否
     */
    Boolean decreaseAccountCommit(BusinessActionContext actionContext);


    /**
     * 从账号扣钱取消
     *
     * @param actionContext
     * @return 是/否
     */
    Boolean decreaseAccountCancel(BusinessActionContext actionContext);
}
