package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.MenuDao;
import main.com.ssh.shop.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("MenuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {

    @Override
    public List<Menu> getAllMenu() {
        String hql = "from Menu";
        return getSession().createQuery(hql).list();
    }
}
