package Test.Dao;

import main.com.ssh.shop.dao.OrdersDao;
import main.com.ssh.shop.dao.ProviderDao;
import main.com.ssh.shop.entity.Orders;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class testOrders {

    private static Logger logger = Logger.getLogger(testOrders.class);

    @Resource
    private OrdersDao ordersDao;

    @Test
    public void testqueryProvider() {
        List<Orders> list = ordersDao.queryToOrders(1, 2);
        if (list != null) {
            System.out.println("不为空");
            for (Orders pr : list) {
                System.out.println(pr.toString());
                pr.getWhlist().getWarehouse().toString();
            }
        }
    }

    @Test
    public void testCountProvider() {
        Long i = ordersDao.getCount();
        System.out.println(i);
    }
}
