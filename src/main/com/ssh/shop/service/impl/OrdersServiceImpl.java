package main.com.ssh.shop.service.impl;

import main.com.ssh.shop.entity.Orders;
import main.com.ssh.shop.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl extends BaseServiceImpl<Orders> implements OrdersService {
    @Override
    public List<Orders> queryToOrders(int page, int size) {
        return ordersDao.queryToOrders(page, size);
    }

    @Override
    public Long getCount() {
        return ordersDao.getCount();
    }
}
