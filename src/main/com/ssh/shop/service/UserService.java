package main.com.ssh.shop.service;


import main.com.ssh.shop.entity.User;

public interface UserService {
    public void save(User user); //用来测试Hibernate环境
    public void update(User user);//更新管理员信息
}
