package cn.mushuwei.account.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:18 下午
 */
@Data
public class AccountDO implements Serializable {
    private static final long serialVersionUID = 6679691095651789876L;

    private Integer id;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 账号余额
     */
    private Double amount;

    /**
     * 冻结数量
     */
    private Double frozenAmount;
}
