package Test.Dao;

import main.com.ssh.shop.entity.Warehouse;
import main.com.ssh.shop.service.WarehouseService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class testWarehouse {
    private static Logger logger = Logger.getLogger(testWarehouse.class);
    @Resource
    private WarehouseService warehouseService;

    @Test
    public void testDao() {
        List<Warehouse> list = warehouseService.queryToWarehouse("", 1, 3);
        for (Warehouse warehouse : list) {
            System.out.println(warehouse.toString());
        }
    }
}
