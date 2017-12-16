package main.com.ssh.shop.service.impl;

import main.com.ssh.shop.entity.Order;
import main.com.ssh.shop.service.OrderService;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
}
