package main.com.ssh.shop.util;

import main.com.ssh.shop.dao.MenuDao;
import main.com.ssh.shop.dao.impl.MenuDaoImpl;
import main.com.ssh.shop.entity.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuUtil {

    public static List<Menu> convertoJson(List<Menu> list2) {
        if (list2 != null) {
            List<Menu> list = new ArrayList<Menu>();
            Map<Integer, Menu> fathermap = new HashMap<Integer, Menu>();
            for (Menu m1 : list2) {
                if (m1.getParent().equals(0))
                    fathermap.put(m1.getId(), m1);
            }

            for (Menu m2 : list2) {
                if (!m2.getParent().equals(0)) {
                    Menu fatherMenu = fathermap.get(m2.getParent());
                    fatherMenu.getSubmenu().add(m2);
                }
            }

            for (Menu m3 : fathermap.values()) {
                list.add(m3);
            }
            return list;
        } else {
            return null;
        }
    }


}
