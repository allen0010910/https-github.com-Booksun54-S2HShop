package main.com.ssh.shop.dao;


import main.com.ssh.shop.entity.Stock;

import java.util.Date;
import java.util.List;

public interface StockDao extends BaseDao<Stock> {

    //查询销售记录
    public List<Stock> queryToStockDao(int page, int size);//实现分页

    //查询销售记录
    public List<Stock> queryToStockDao();

    //查询总记录数
    public Long getCount();

    //查询总记录数
    public Long getCount(int id);

    //更新Stock部分属性
    public void updateStock(int id, int num, Double sellprice, Double money, Date date);

    //通过id获取Stock对象
    public Stock getStockByid(int id);

    public List<Stock> searchbyid(int id, int page, int size);
}
