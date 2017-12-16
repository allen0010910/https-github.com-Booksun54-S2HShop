package Test.Dao;


import main.com.ssh.shop.dao.ProviderDao;
import main.com.ssh.shop.entity.Provider;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class testProvider {

    private static Logger logger = Logger.getLogger(testProvider.class);

    @Resource
    private ProviderDao providerDao;

    @Test
    public void testProviderDao() {
        Provider provider = new Provider("老张", "15928588629", "提供大量零食", "高新区");
        providerDao.save(provider);
        Provider provider1 = providerDao.get(1);
        if (provider1 != null)
            System.out.println(provider1.toString());
    }

    @Test
    public void testqueryProvider() {
        List<Provider> list = providerDao.queryToProvider("老王  ", 1, 2);
        if (list != null) {
            System.out.println("不为空");
            for (Provider pr : list) {
                System.out.println(pr.toString());
            }
        }
    }

    @Test
    public void testCountProvider() {
        Long i = providerDao.getCount("");
        System.out.println(i);
    }

    @Test
    public void testSearch() {
        List<Provider> provider = providerDao.queryToProvider("老", 1, 1);
        for (Provider provider1 : provider) {
            System.out.println(provider1.toString());
        }
    }
}
