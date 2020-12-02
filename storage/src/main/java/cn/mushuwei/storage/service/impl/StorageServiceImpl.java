package cn.mushuwei.storage.service.impl;

import cn.mushuwei.storage.api.dto.CommodityDTO;
import cn.mushuwei.storage.dao.StorageDao;
import cn.mushuwei.storage.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:47 上午
 */
@Service("storageService")
public class StorageServiceImpl implements StorageService {

    @Resource(name = "storageDao")
    private StorageDao storageDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean decreaseStoragePrepare(CommodityDTO commodityDTO) {
        int storage = storageDao.tccDecreaseStoragePrepare(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        if (storage > 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean decreaseStorageCommit(CommodityDTO commodityDTO) {
        int storage = storageDao.tccDecreaseStorageCommit(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        if (storage > 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean decreaseStorageCancel(CommodityDTO commodityDTO) {
        int storage = storageDao.tccDecreaseStorageCancel(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        if (storage > 0) {
            return true;
        }
        return false;
    }
}
