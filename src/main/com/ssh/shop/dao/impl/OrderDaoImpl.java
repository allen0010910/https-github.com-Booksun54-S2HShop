package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.OrderDao;
import main.com.ssh.shop.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

    @Override
    public List<Order> queryToOrderDao(int page, int size) {
        String hql;
        hql = "from Order";
        return getSession().createQuery(hql).
                setFirstResult((page - 1) * size).
                setMaxResults(size).list();
    }

    @Override
    public Long getCount() {
        String hql;
        hql = "select count(c) from Order c";
        return (Long) getSession().createQuery(hql).uniqueResult();
    }

}
