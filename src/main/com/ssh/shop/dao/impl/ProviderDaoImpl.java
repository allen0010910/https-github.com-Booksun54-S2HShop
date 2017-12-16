package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.ProviderDao;
import main.com.ssh.shop.entity.Provider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("providerDao")
public class ProviderDaoImpl extends BaseDaoImpl<Provider> implements ProviderDao {

    @Override
    public List<Provider> queryToProvider(String pname, int page, int size) {
        String hql;
        pname = pname.trim();
        if (!pname.equals("") && !pname.equals(" ")) {
            hql = "from Provider as p where p.pname like :pname";
            //System.out.println("1");
            return getSession().createQuery(hql).
                    setString("pname", "%" + pname + "%").
                    setFirstResult((page - 1) * size).
                    setMaxResults(size).list();
        } else {
            hql = "from Provider";
            System.out.println("2");
            return getSession().createQuery(hql).
                    setFirstResult((page - 1) * size).
                    setMaxResults(size).list();
        }


    }

    @Override
    public Long getCount(String pname) {
        pname = pname.trim();
        String hql;
        if (pname != null || !pname.equals("")) {
            hql = "select count(c) from Provider c where c.pname like :pname";
        } else {
            hql = "select count(c) from Provider c";
        }
        return (Long) getSession().createQuery(hql)
                .setString("pname", "%" + pname + "%")
                .uniqueResult(); //返回一条记录:总记录数
    }

    @Override
    public void deleteProvider(int pno) {
        String hql = "delete from Provider as c where c.pno = :pno";
        getSession().createQuery(hql).setInteger("pno", pno).executeUpdate();
    }
}
