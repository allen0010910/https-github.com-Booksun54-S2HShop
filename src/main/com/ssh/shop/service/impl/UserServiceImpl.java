package main.com.ssh.shop.service.impl;

import main.com.ssh.shop.entity.User;
import main.com.ssh.shop.service.UserService;
import main.com.ssh.shop.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Override
    public User getUser(String userid) {
        return userDao.getUser(userid);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
