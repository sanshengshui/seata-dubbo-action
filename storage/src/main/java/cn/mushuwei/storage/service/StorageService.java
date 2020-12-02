package cn.mushuwei.storage.service;

import cn.mushuwei.storage.api.dto.CommodityDTO;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:35 上午
 */
public interface StorageService {


    /**
     * 扣减库存准备
     *
     * @param commodityDTO 库存信息
     * @return
     */
    Boolean decreaseStoragePrepare(CommodityDTO commodityDTO);

    /**
     * 扣减库存提交
     *
     * @param commodityDTO
     * @return
     */
    Boolean decreaseStorageCommit(CommodityDTO commodityDTO);

    /**
     * 扣减库存回滚
     *
     * @param commodityDTO
     * @return
     */
    Boolean decreaseStorageCancel(CommodityDTO commodityDTO);
}
