package main.com.ssh.shop.dao;

import main.com.ssh.shop.entity.Order;

import java.util.List;

public interface OrderDao extends BaseDao<Order> {

    //查询进货记录
    public List<Order> queryToOrderDao(int page, int size);//实现分页

    //查询总记录数
    public Long getCount();

}
