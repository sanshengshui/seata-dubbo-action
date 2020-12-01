package cn.mushuwei.storage.service;

import cn.mushuwei.storage.api.dto.CommodityDTO;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:35 上午
 */
public interface StorageService {

    Boolean decreaseStorage(CommodityDTO commodityDTO);
}
