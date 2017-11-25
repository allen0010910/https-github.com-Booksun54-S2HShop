package main.com.ssh.shop.dao;

import main.com.ssh.shop.entity.User;

public interface UserDao extends BaseDao<User> {
    //
    public User login(User user);
}
