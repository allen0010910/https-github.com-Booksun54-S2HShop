package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.WarehouseDao;
import main.com.ssh.shop.entity.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("warehouseDao")
public class WarehouseDaoImpl extends BaseDaoImpl<Warehouse> implements WarehouseDao {
    @Override
    public List<Warehouse> queryToWarehouse(String name, int page, int size) {
        String hql;
        name = name.trim();
        if (!name.equals("") && !name.equals(" ")) {
            hql = "from Warehouse as p where p.name like :name";
            //System.out.println("1");
            return getSession().createQuery(hql).
                    setString("name", "%" + name + "%").
                    setFirstResult((page - 1) * size).
                    setMaxResults(size).list();
        } else {
            hql = "from Warehouse ";
            //System.out.println("2");
            return getSession().createQuery(hql).
                    setFirstResult((page - 1) * size).
                    setMaxResults(size).list();
        }
    }

    @Override
    public Long getCount(String name) {
        name = name.trim();
        String hql;
        if (name != null || !name.equals("")) {
            hql = "select count(c) from Warehouse c where c.name like :name";
        } else {
            hql = "select count(c) from Provider c";
        }
        return (Long) getSession().createQuery(hql)
                .setString("name", "%" + name + "%")
                .uniqueResult(); //返回一条记录:总记录数
    }

    @Override
    public void deleteWarehouse(int id) {
        String hql = "delete from Warehouse as c where c.id = :id";
        getSession().createQuery(hql).setInteger("id", id).executeUpdate();
    }
}
