package cn.mushuwei.account.api;

import cn.mushuwei.account.api.dto.AccountDTO;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:20 下午
 */
public interface AccountApi {

    Boolean decreaseAccount(AccountDTO accountDTO);
}
