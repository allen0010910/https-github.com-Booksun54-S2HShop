package Test.Dao;

import main.com.ssh.shop.dao.OrderDao;
import main.com.ssh.shop.entity.Order;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class testOrderDao {

    private static Logger logger = Logger.getLogger(testOrderDao.class);

    @Resource
    private OrderDao orderDao;

    @Test
    public void testqueryOrderDao() {
        List<Order> list = orderDao.queryToOrderDao(1,2);
        if(list!=null){
            System.out.print("不为空!");
            for(Order o:list){
                System.out.print(o.toString());
            }
        }
    }

    @Test
    public void testcountOrderDao(){
        Long i = orderDao.getCount();
        System.out.println("测试数据："+i);
    }
}
