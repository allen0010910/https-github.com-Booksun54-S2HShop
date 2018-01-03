package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.StockDao;
import main.com.ssh.shop.entity.Stock;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("stockDao")
public class StockDaoImpl extends BaseDaoImpl<Stock> implements StockDao {
    @Override
    public List<Stock> queryToStockDao(int page, int size) {
        String hql;
        hql = "from Stock ";
        return getSession().createQuery(hql).
                setFirstResult((page - 1) * size).
                setMaxResults(size).list();
    }

    @Override
    public List<Stock> queryToStockDao() {
        String hql;
        hql = "from Stock ";
        return getSession().createQuery(hql).list();
    }

    @Override
    public Long getCount() {
        String hql;
        hql = "select count(c) from Stock c";
        return (Long) getSession().createQuery(hql).uniqueResult();
    }

    @Override
    public void updateStock(int id, int num, Double sellprice, Double money, Date date) {
        String hql = "update Stock s set s.num =:num ,s.sellprice =:sellprice,s.money =:money ,s.date =:date where id=:id";
        getSession().createQuery(hql).setInteger("id", id).setInteger("num", num).setDouble("sellprice", sellprice).setDouble("money", money).setDate("date", date).executeUpdate();
    }

    @Override
    public Stock getStockByid(int id) {
        String hql = "from Stock s where s.id=:id";
        return (Stock) getSession().createQuery(hql).setInteger("id", id).uniqueResult();
    }
}
