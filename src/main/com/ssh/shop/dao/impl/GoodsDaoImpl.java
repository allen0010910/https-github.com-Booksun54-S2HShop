package main.com.ssh.shop.dao.impl;


import main.com.ssh.shop.dao.GoodsDao;
import main.com.ssh.shop.entity.Goods;
import org.springframework.stereotype.Repository;

@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao {

}
