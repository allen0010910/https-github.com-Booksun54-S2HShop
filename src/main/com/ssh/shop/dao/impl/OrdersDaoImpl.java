package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.OrdersDao;
import main.com.ssh.shop.entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("ordersDao")
public class OrdersDaoImpl extends BaseDaoImpl<Orders> implements OrdersDao {
    @Override
    public List<Orders> queryToOrders(int page, int size) {
        String hql = "from Orders";
        return getSession().createQuery(hql).
                setFirstResult((page - 1) * size).
                setMaxResults(size).list();
    }

    @Override
    public Long getCount() {
        String hql;
        hql = "select count(c) from Orders c";
        return (Long) getSession().createQuery(hql).uniqueResult();
    }

    @Override
    public void updateOrders(int id, int num, Double price, Double money, Date date) {
        String hql = "update Orders s set s.num =:num ,s.price =:price,s.sum =:sum ,s.date =:date where id=:id";
        getSession().createQuery(hql).setInteger("id", id).setInteger("num", num).setDouble("price", price).
                setDouble("sum", money).setDate("date", date).executeUpdate();
    }
}
