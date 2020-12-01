package cn.mushuwei.account.service.impl;

import cn.mushuwei.account.api.dto.AccountDTO;
import cn.mushuwei.account.dao.AccountDao;
import cn.mushuwei.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:22 下午
 */
@Slf4j
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean decreaseAccount(AccountDTO accountDTO) {
        int account = accountDao.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        if (account > 0) {
            return true;
        }
        return false;
    }
}
