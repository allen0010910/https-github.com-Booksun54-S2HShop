package Test.Dao;

import main.com.ssh.shop.dao.UserDao;
import main.com.ssh.shop.entity.User;
import main.com.ssh.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class TestDao {

    @Resource
    private UserDao userDao;
    @Resource
    private UserService userService;

    @Test //测试Hibernate和Spring整合后
    public void testlogin() {
        User user = userDao.login(new User("root", "123"));
        if (user != null) {
            System.out.println(user.toString());
        }
    }

    @Test //测试Hibernate和Spring整合后
    public void testloginService() {
        User user = userService.login(new User("root", "123"));
        if (user != null) {
            System.out.println(user.toString());
        }
    }
}
