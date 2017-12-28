package main.com.ssh.shop.service;


import main.com.ssh.shop.entity.Stock;

import java.util.List;

public interface StockService extends BaseService<Stock> {

    public List<Stock> queryToStock(int page, int size);//实现分页

    public Long getCount();

}
