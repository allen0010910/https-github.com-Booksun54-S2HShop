package main.com.ssh.shop.service;

import main.com.ssh.shop.entity.Goods;

public interface GoodsService extends BaseService<Goods> {
    public void save(Goods goods);

    public void update(Goods goods);
}
