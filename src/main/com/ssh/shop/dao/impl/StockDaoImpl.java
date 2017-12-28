package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.StockDao;
import main.com.ssh.shop.entity.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("stockDao")
public class StockDaoImpl extends BaseDaoImpl<Stock> implements StockDao {
    @Override
    public List<Stock> queryToStockDao(int page, int size) {
        String hql;
        hql = "from Stock";
        return getSession().createQuery(hql).
                setFirstResult((page - 1) * size).
                setMaxResults(size).list();
    }

    @Override
    public Long getCount() {
        String hql;
        hql = "select count(c) from Stock c";
        return (Long) getSession().createQuery(hql).uniqueResult();
    }
}
