package main.com.ssh.shop.service;


import main.com.ssh.shop.entity.Stock;

import java.util.Date;
import java.util.List;

public interface StockService extends BaseService<Stock> {

    public List<Stock> queryToStock(int page, int size);//实现分页

    public Long getCount();

    //更新Stock部分属性
    public void updateStock(int id, int num, Double sellprice, Double money, Date date);

}
