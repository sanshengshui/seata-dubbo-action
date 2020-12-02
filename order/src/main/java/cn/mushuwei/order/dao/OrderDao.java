package cn.mushuwei.order.dao;

import cn.mushuwei.order.entity.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:49 下午
 */
@Repository("orderDao")
public interface OrderDao {

    /**
     * 创建订单准备
     *
     * @param orderDO
     */
    void tccCreateOrderPrepare(@Param("order") OrderDO orderDO);

    /**
     * 创建订单提交/取消
     *
     */
    int tccCreateOrderCommitOrCancel(@Param("status") Integer status, @Param("orderNo") String orderNo);
}
