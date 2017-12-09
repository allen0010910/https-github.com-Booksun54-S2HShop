package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.UserDao;
import main.com.ssh.shop.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User login(User user) {
        String hql = "from User u where u.userid=:userid and u.password=:password";
        return (User) getSession().createQuery(hql) //
                .setString("userid", user.getUserid()) //
                .setString("password", user.getPassword()) //
                .uniqueResult();
    }

    @Override
    public User getUser(String userid) {
        String hql = "from User u where u.userid=:userid";
        return (User) getSession().createQuery(hql).setString("userid", userid).uniqueResult();
    }


}
