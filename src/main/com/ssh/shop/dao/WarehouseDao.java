package main.com.ssh.shop.dao;

import main.com.ssh.shop.entity.Warehouse;

import java.util.List;

public interface WarehouseDao extends BaseDao<Warehouse> {

    //分页查询
    public List<Warehouse> queryToWarehouse(String name, int page, int size);

    //根据关键字查询总记录数
    public Long getCount(String name);

    public void deleteWarehouse(int id);

}
