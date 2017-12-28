package main.com.ssh.shop.dao;


import main.com.ssh.shop.entity.Stock;

import java.util.List;

public interface StockDao extends BaseDao<Stock> {

    //查询销售记录
    public List<Stock> queryToStockDao(int page, int size);//实现分页

    //查询总记录数
    public Long getCount();
}
