package cn.mushuwei.order.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:58 下午
 */
@Data
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = -9053937237521880163L;

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
    private String commodityCode;

    /**
     * 订单数量
     */
    private Integer orderCount;

    /**
     * 消费总金额
     */
    private BigDecimal orderAmount;
}
