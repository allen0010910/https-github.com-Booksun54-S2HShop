package Test.Dao;

import main.com.ssh.shop.dao.WhlistDao;
import main.com.ssh.shop.entity.Whlist;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class testWhlistDao {

    private static Logger logger = Logger.getLogger(testWhlistDao.class);
    @Resource
    private WhlistDao whlistDao;

    @Test
    public void testDao() {
        List<Whlist> list = whlistDao.queryToWhlist(3, 1, 3);
        for (Whlist w :
                list) {
            System.out.println(w.toString());
        }
    }

    @Test
    public void testDao2() {
        List<Whlist> list = whlistDao.searchbyname("雪碧", 3, 1, 3);
        for (Whlist w :
                list) {
            System.out.println(w.toString());
        }
    }
}
