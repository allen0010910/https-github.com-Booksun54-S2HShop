package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.OrderDao;
import main.com.ssh.shop.entity.Order;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {
}
