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
    public User login(User user) {
        String hql = "from User u where u.userid=:userid and u.password=:password";
        return (User) getSession().createQuery(hql) //
                .setString("userid", user.getUserid()) //
                .setString("password", user.getPassword()) //
                .uniqueResult();
    }
}
