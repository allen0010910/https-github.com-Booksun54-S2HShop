package main.com.ssh.shop.service;

import main.com.ssh.shop.entity.Warehouse;

import java.util.List;

public interface WarehouseService extends BaseService<Warehouse> {

    //分页查询
    public List<Warehouse> queryToWarehouse(String name, int page, int size);

    //根据关键字查询总记录数
    public Long getCount(String name);

    //删除仓库信息
    public void deleteWarehouse(int id);
}
