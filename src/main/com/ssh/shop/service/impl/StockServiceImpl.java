package main.com.ssh.shop.service.impl;

import main.com.ssh.shop.entity.Stock;
import main.com.ssh.shop.service.StockService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("stockService")
public class StockServiceImpl extends BaseServiceImpl<Stock> implements StockService {
    @Override
    public List<Stock> queryToStock(int page, int size) {

        return stockDao.queryToStockDao(page, size);
    }

    @Override
    public List<Stock> queryToStock() {
        return stockDao.queryToStockDao();
    }

    @Override
    public Long getCount() {
        return stockDao.getCount();
    }

    @Override
    public Long getCount(int id) {
        return stockDao.getCount(id);
    }

    @Override
    public void updateStock(int id, int num, Double sellprice, Double money, Date date) {
        stockDao.updateStock(id, num, sellprice, money, date);
    }

    @Override
    public Stock getStockByid(int id) {
        return stockDao.getStockByid(id);
    }

    @Override
    public List<Stock> searchbyid(int id, int page, int size) {
        return stockDao.searchbyid(id, page, size);
    }
}
