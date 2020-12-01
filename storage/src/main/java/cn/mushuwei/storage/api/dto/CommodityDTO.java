package cn.mushuwei.storage.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:38 上午
 */
@Data
public class CommodityDTO implements Serializable {
    private static final long serialVersionUID = 3780799651310134581L;

    private Integer id;
    private String commodityCode;
    private String name;
    private Integer count;
}
