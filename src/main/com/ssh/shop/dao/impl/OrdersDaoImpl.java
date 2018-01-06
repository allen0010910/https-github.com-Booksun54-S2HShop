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
    public Long getCount(int id) {
        String hql;
        hql = "select count(c) from Orders c where c.id=:id";
        return (Long) getSession().createQuery(hql).setInteger("id", id).uniqueResult();
    }

    @Override
    public void updateOrders(int id, int num, Double price, Double money, Date date) {
        String hql = "update Orders s set s.num =:num ,s.price =:price,s.sum =:sum ,s.date =:date where id=:id";
        getSession().createQuery(hql).setInteger("id", id).setInteger("num", num).setDouble("price", price).
                setDouble("sum", money).setDate("date", date).executeUpdate();
    }

    @Override
    public Orders getOrdersByid(int id) {
        String hql = "from Orders o where o.id=:id";
        return (Orders) getSession().createQuery(hql).setInteger("id", id).uniqueResult();
    }

    @Override
    public List<Orders> searchbyid(int id, int page, int size) {

        String hql = "from Orders s where s.id=:id";
        return getSession().createQuery(hql).setInteger("id", id).
                setFirstResult((page - 1) * size).
                setMaxResults(size).list();
    }
}
