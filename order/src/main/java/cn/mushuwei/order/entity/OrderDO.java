package cn.mushuwei.order.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:52 下午
 */
@Data
public class OrderDO implements Serializable {
    private static final long serialVersionUID = 5496862773012381024L;

    private Integer id;

    private String orderNo;

    private String userId;

    private String code;

    private Integer count;

    private Double amount;
}
