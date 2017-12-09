package Test.Dao;

import com.alibaba.fastjson.JSON;
import main.com.ssh.shop.dao.GoodsDao;
import main.com.ssh.shop.dao.MenuDao;
import main.com.ssh.shop.dao.UserDao;
import main.com.ssh.shop.entity.Goods;
import main.com.ssh.shop.entity.Menu;
import main.com.ssh.shop.entity.User;
import main.com.ssh.shop.service.MenuService;
import main.com.ssh.shop.service.UserService;
import main.com.ssh.shop.util.MenuUtil;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class TestDao {

    @Resource
    private UserDao userDao;
    @Resource
    private UserService userService;
    @Resource
    private MenuDao menuDao;
    @Resource
    private MenuService menuService;
    @Resource
    private GoodsDao goodsDao;

    private static Logger logger = Logger.getLogger(TestDao.class);


    @Test //测试Hibernate和Spring整合后
    public void testcreate() {
        Configuration conf = new Configuration();

        conf.configure("/hibernate.cfg.xml");

        SchemaExport dbExport = new SchemaExport(conf);

        dbExport.create(true, true);
    }

    @Test //测试Hibernate和Spring整合后
    public void testlogin() {
        User user = userDao.login(new User("root", "123"));
        if (user != null) {
            System.out.println(user.toString());
        }
    }

    @Test //测试Hibernate和Spring整合后
    public void testcreateUser() {
        userDao.save(new User("root", "123"));
        User user = userDao.getUser("root");

    }

    @Test
    public void testgetUser() {
        User user = userDao.getUser("root");
        if (user != null) {
            //System.out.println(user.toString());
            logger.info(user.toString());
        }
    }


    @Test //测试Hibernate和Spring整合后
    public void testloginService() {
        User user = userService.login(new User("root", "1234"));
        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("登录失败!");
        }
    }

    @Test //测试Hibernate和Spring整合后
    public void testMenuALL() {
        List<Menu> query = new ArrayList<Menu>();
        query = menuService.query();

        for (Menu i : query) {
            System.out.println(i.toString());
            logger.info(i.toString());
        }

        List<Menu> query2 = MenuUtil.convertoJson(query);
        String jsonString = JSON.toJSONString(query2);
        logger.info(jsonString);
    }


    @Test //测试Hibernate和Spring整合后
    public void testGoods() {
        Goods goods = new Goods("皮鞋", "鞋", "好看的皮鞋");
        goodsDao.save(goods);
    }
}
