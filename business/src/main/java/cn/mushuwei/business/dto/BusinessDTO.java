package cn.mushuwei.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:33 下午
 */
@Data
public class BusinessDTO implements Serializable {
    private static final long serialVersionUID = -5408279514374338101L;

    private String userId;

    private String commodityCode;

    private String name;

    private Integer count;

    private BigDecimal amount;
}
