package cn.mushuwei.account.service;

import cn.mushuwei.account.api.dto.AccountDTO;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:19 下午
 */
public interface AccountService {

    /**
     * 扣用户钱
     * @param accountDTO
     * @return
     */
    Boolean decreaseAccount(AccountDTO accountDTO);
}
