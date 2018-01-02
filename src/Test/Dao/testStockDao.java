package Test.Dao;

import main.com.ssh.shop.dao.StockDao;
import main.com.ssh.shop.entity.Provider;
import main.com.ssh.shop.entity.Stock;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class testStockDao {

    private static Logger logger = Logger.getLogger(testStockDao.class);

    @Resource
    private StockDao stockDao;

    @Test
    public void testqueryStockDao() {
        List<Stock> list = stockDao.queryToStockDao(1, 2);
        if (list != null) {
            System.out.print("不为空!");
            for (Stock s : list) {
                System.out.print(s.toString());
            }
        }
    }

    @Test
    public void testcountStockDao() {
        Long i = stockDao.getCount();
        System.out.println("测试数据：" + i);
    }

    @Test
    public void testStockbyidDao() {
        Stock stock = stockDao.getStockByid(1);
        System.out.println("测试数据：" + stock.toString());
    }
}
