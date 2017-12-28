package main.com.ssh.shop.service;

import main.com.ssh.shop.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public interface OrderService extends BaseService<Order> {

    public List<Order> queryToOrder(int page, int size);//实现分页

    public Long getCount();

}
