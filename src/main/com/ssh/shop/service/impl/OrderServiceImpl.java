package main.com.ssh.shop.service.impl;

import main.com.ssh.shop.entity.Order;
import main.com.ssh.shop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    @Override
    public List<Order> queryToOrder(int page, int size) {

        return orderDao.queryToOrderDao(page, size);
    }

    @Override
    public Long getCount() {
        return orderDao.getCount();
    }
}
