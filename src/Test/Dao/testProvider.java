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
        Provider provider = new Provider("老王", "15928588609", "提供大量军火", "高新区");
        providerDao.save(provider);
        Provider provider1 = providerDao.get(1);
        if (provider1 != null)
            System.out.println(provider1.toString());
    }
}
