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

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 消费总金额
     */
    private Double amount;

    /**
     * 状态，1-预创建；2-创建成功；3-创建失败
     */
    private Integer status;
}
