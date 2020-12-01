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

    void createOrder(@Param("order") OrderDO orderDO);

    OrderDO getById(Integer id);
}
