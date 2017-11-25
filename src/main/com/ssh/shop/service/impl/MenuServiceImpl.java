package main.com.ssh.shop.service.impl;

import main.com.ssh.shop.dao.MenuDao;
import main.com.ssh.shop.entity.Menu;
import main.com.ssh.shop.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {
    @Resource
    private MenuDao menuDao;

    @Override
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }
}
