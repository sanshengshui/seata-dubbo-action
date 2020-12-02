package cn.mushuwei.account.service;

import cn.mushuwei.account.api.dto.AccountDTO;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:19 下午
 */
public interface AccountService {

    /**
     * 扣用户钱准备
     *
     * @param accountDTO
     * @return
     */
    Boolean decreaseAccountPrepare(AccountDTO accountDTO);

    /**
     * 扣用户钱提交
     *
     * @param accountDTO
     * @return
     */
    Boolean decreaseAccountCommit(AccountDTO accountDTO);


    /**
     * 扣用户钱回滚
     *
     * @param accountDTO
     * @return
     */
    Boolean decreaseAccountCancel(AccountDTO accountDTO);
}
