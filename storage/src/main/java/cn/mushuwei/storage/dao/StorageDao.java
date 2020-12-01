package cn.mushuwei.storage.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jamesmsw
 * @date 2020/11/30 7:46 下午
 */
@Repository("storageDao")
public interface StorageDao {

    /**
     * 扣减商品库存
     *
     * @param commodityCode 商品code
     * @param count 扣减数量
     * @return
     */
    int decreaseStorage(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}
