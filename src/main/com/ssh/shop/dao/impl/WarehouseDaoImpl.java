package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.WarehouseDao;
import main.com.ssh.shop.entity.Warehouse;
import org.springframework.stereotype.Repository;

@Repository("warehouseDao")
public class WarehouseDaoImpl extends BaseDaoImpl<Warehouse> implements WarehouseDao {
}
