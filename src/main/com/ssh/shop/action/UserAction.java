package main.com.ssh.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import main.com.ssh.shop.entity.User;
import main.com.ssh.shop.service.UserService;

public class UserAction extends ActionSupport {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String update(){
        System.out.println("-----update-----");
        System.out.println(userService);
        userService.update(user);
        return "index";
    }

    public String save(){
        System.out.println("----save----");
        System.out.println(userService);
        return  "index";
    }
}
