package main.com.ssh.shop.service;

import main.com.ssh.shop.entity.Order;
import org.springframework.stereotype.Service;

@Service("orderService")
public interface OrderService extends BaseService<Order> {
}
