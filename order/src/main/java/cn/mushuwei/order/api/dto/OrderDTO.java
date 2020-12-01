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

    private String orderNo;

    private String userId;

    private String commodityCode;

    private Integer orderCount;

    private BigDecimal orderAmount;
}
