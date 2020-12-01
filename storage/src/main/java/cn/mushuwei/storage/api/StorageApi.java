package cn.mushuwei.storage.api;

import cn.mushuwei.storage.api.dto.CommodityDTO;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:37 上午
 */
public interface StorageApi {


    Boolean decreaseStorage(CommodityDTO commodityDTO);
}
