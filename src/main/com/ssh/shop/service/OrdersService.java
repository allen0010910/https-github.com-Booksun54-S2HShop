package main.com.ssh.shop.service;

import main.com.ssh.shop.entity.Orders;

import java.util.List;

public interface OrdersService extends BaseService<Orders> {

    //查询供应商名称
    public List<Orders> queryToOrders(int page, int size);//实现分页

    //根据关键字查询总记录数
    public Long getCount();

}
