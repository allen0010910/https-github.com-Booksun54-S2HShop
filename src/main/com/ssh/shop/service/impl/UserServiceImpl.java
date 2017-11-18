package main.com.ssh.shop.service.impl;

import main.com.ssh.shop.entity.User;
import main.com.ssh.shop.service.UserService;
import main.com.ssh.shop.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserServiceImpl implements UserService {
    /*Spring和Hibernate整个后*/
    private SessionFactory sessionFactory; //定义一个sessionFactory

    //当需要使用sessoinFactory的时候，Spring会将sessionFactory注入进来
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    protected Session getSession() {
        //从当前线程获取session，如果没有则创建一个新的session
        return sessionFactory.getCurrentSession();
    }

    public void save(User user) {
        getSession().save(user);
    }

    public void update(User user) {
        getSession().update(user);
    }
}
