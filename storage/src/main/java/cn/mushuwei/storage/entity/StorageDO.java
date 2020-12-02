package cn.mushuwei.storage.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:45 上午
 */
@Data
public class StorageDO implements Serializable {
    private static final long serialVersionUID = -5615156057126774764L;

    private Integer id;
    /**
     * 商品编码
     */
    private String commodityCode;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品库存数
     */
    private Integer count;

    /**
     * 冻结数量
     */
    private Integer frozenCount;
}
