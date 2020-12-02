package cn.mushuwei.account.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:20 下午
 */
@Data
public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 145966622139816557L;

    private Integer id;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 账号余额
     */
    private BigDecimal amount;
}
