package main.com.ssh.shop.dao;

import main.com.ssh.shop.entity.Menu;

import java.util.List;


public interface MenuDao extends BaseDao<Menu> {

    public List<Menu> getAllMenu();

}
