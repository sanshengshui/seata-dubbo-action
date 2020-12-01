package cn.mushuwei.account.provider;

import cn.mushuwei.account.api.AccountApi;
import cn.mushuwei.account.api.dto.AccountDTO;
import cn.mushuwei.account.service.AccountService;
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
    public Boolean decreaseAccount(AccountDTO accountDTO) {
        try {
            Boolean result = accountService.decreaseAccount(accountDTO);
            if (result) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.info("服务调用异常, accountDTO: {}", accountDTO);
        }
        return false;
    }
}
