package cn.mushuwei.account.provider;

import cn.mushuwei.account.api.AccountApi;
import cn.mushuwei.account.api.dto.AccountDTO;
import cn.mushuwei.account.service.AccountService;
import com.alibaba.fastjson.JSON;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:24 下午
 */
@DubboService
@Component
@Slf4j
public class AccountApiImpl implements AccountApi {

    @Resource(name = "accountService")
    private AccountService accountService;


    @Override
    public Boolean decreaseAccountPrepare(BusinessActionContext actionContext, AccountDTO accountDTO) {
        log.info("accountDTO: {}, actionContext: {}",accountDTO, actionContext);
        try {
            Boolean result = accountService.decreaseAccountPrepare(accountDTO);
            if (!result) {
                return false;
            }
            return true;
        } catch (Exception e) {
            log.info("服务调用异常, accountDTO: {}", accountDTO);
        }
        return false;
    }

    @Override
    public Boolean decreaseAccountCommit(BusinessActionContext actionContext) {
        AccountDTO accountDTO = JSON.parseObject(JSON.toJSONString(actionContext.getActionContext("accountDTO")), AccountDTO.class);
        try {
            Boolean result = accountService.decreaseAccountCommit(accountDTO);
            if (!result) {
                return false;
            }
            return true;
        } catch (Exception e) {
            log.info("服务调用异常, accountDTO: {}", accountDTO);
        }
        return false;
    }

    @Override
    public Boolean decreaseAccountCancel(BusinessActionContext actionContext) {
        AccountDTO accountDTO = JSON.parseObject(JSON.toJSONString(actionContext.getActionContext("accountDTO")), AccountDTO.class);
        try {
            Boolean result = accountService.decreaseAccountCancel(accountDTO);
            if (!result) {
                return false;
            }
            return true;
        } catch (Exception e) {
            log.info("服务调用异常, accountDTO: {}", accountDTO);
        }
        return false;
    }
}
