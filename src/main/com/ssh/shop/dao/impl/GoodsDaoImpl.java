package main.com.ssh.shop.dao.impl;


import main.com.ssh.shop.dao.GoodsDao;
import main.com.ssh.shop.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao {

    @Override
    public List<Goods> queryToGoods(String name, int page, int size) {
        String hql;
        name = name.trim();
        if (!name.equals("") && !name.equals(" ")) {
            hql = "from Goods as p where p.name like :name";
            //System.out.println("1");
            if (page != 0 && size != 0) {
                return getSession().createQuery(hql).
                        setString("name", "%" + name + "%").
                        setFirstResult((page - 1) * size).
                        setMaxResults(size).list();
            }
            return getSession().createQuery(hql).
                    setString("name", "%" + name + "%").list();
        } else {
            hql = "from Goods";
            System.out.println("2");
            if (page != 0 && size != 0) {
                return getSession().createQuery(hql).
                        setFirstResult((page - 1) * size).
                        setMaxResults(size).list();
            }
            return getSession().createQuery(hql).list();
        }

    }

    @Override
    public Long getCount(String name) {
        name = name.trim();
        String hql;
        if (name != null || !name.equals("")) {
            hql = "select count(c) from Goods c where c.name like :name";
        } else {
            hql = "select count(c) from Goods c";
        }
        return (Long) getSession().createQuery(hql)
                .setString("name", "%" + name + "%")
                .uniqueResult(); //返回一条记录:总记录数
    }

    @Override
    public void updateGoods(int id, String name, String samary, Double price, String type) {
        String hql = "update Goods s set s.name=:name,s.samary=:samary,s.price=:price,s.type=:type where id=:id";
        getSession().createQuery(hql).setInteger("id", id).setString("name", name).setString("samary", samary).setString("type", type).setDouble("price", price).executeUpdate();
    }

    @Override
    public Goods queryToGoods(int id) {
        String hql;
        hql = "from Goods s where s.id=:id";
        return (Goods) getSession().createQuery(hql).setInteger("id", id).uniqueResult();
    }
}
