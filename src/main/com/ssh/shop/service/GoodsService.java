package main.com.ssh.shop.service;

import main.com.ssh.shop.entity.Goods;

import java.util.List;

public interface GoodsService extends BaseService<Goods> {
    //查询商品名称
    public List<Goods> queryToGoods(String name, int page, int size);//实现分页

    //查询商品
    public Goods queryToGoods(int id);//实现分页

    //更新Orders部分属性
    public void updateGoods(int id, String name, String samary, Double price, String type);

    //根据关键字查询总记录数
    public Long getCount(String name);
}
