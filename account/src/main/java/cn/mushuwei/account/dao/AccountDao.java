package cn.mushuwei.account.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:13 下午
 */
@Repository("accountDao")
public interface AccountDao {

    /**
     * 扣减账号余额
     *
     * @param userId 用户编号
     * @param amount 钱数量
     * @return
     */
    int decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);
}
