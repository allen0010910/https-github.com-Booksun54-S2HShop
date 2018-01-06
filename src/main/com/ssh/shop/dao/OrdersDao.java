package main.com.ssh.shop.dao;

import main.com.ssh.shop.entity.Orders;
import main.com.ssh.shop.entity.Provider;

import java.util.Date;
import java.util.List;

public interface OrdersDao {

    //查询供应商名称
    public List<Orders> queryToOrders(int page, int size);//实现分页

    //根据关键字查询总记录数
    public Long getCount();

    //根据关键字查询总记录数
    public Long getCount(int id);

    //更新Orders部分属性
    public void updateOrders(int id, int num, Double price, Double money, Date date);

    //通过id获取Stock对象
    public Orders getOrdersByid(int id);

    public List<Orders> searchbyid(int id, int page, int size);
}
