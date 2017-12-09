package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.StockDao;
import main.com.ssh.shop.entity.Stock;
import org.springframework.stereotype.Repository;

@Repository("stockDao")
public class StockDaoImpl extends BaseDaoImpl<Stock> implements StockDao {
}
