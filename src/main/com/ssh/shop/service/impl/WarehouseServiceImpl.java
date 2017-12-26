package main.com.ssh.shop.service.impl;

import main.com.ssh.shop.entity.Warehouse;
import main.com.ssh.shop.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("warehouseService")
public class WarehouseServiceImpl extends BaseServiceImpl<Warehouse> implements WarehouseService {
    @Override
    public List<Warehouse> queryToWarehouse(String name, int page, int size) {
        return warehouseDao.queryToWarehouse(name, page, size);
    }

    @Override
    public Long getCount(String name) {
        return warehouseDao.getCount(name);
    }

    @Override
    public void deleteWarehouse(int id) {
        warehouseDao.deleteWarehouse(id);
    }
}
