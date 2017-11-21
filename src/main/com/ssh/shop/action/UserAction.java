package main.com.ssh.shop.action;


import com.opensymphony.xwork2.ModelDriven;
import main.com.ssh.shop.entity.User;
import main.com.ssh.shop.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    public String update() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
        System.out.println("id" + id);
        System.out.println("---update---");
        System.out.println("model" + model);
        userService.update(model);
        return "index";
    }

    public String save() {
        System.out.println("---save---");
        System.out.println(model);
        userService.save(model);
        return "index";
    }

    public String query() {
        request.put("userList", userService.query());
        session.put("userList", userService.query());
        application.put("userList", userService.query());
        return "index";
    }

    public String login() {
        System.out.println("进入登陆!");
        model = userService.login(model);
        System.out.println(model.toString() + "登录信息");
        if (model == null) {
            session.put("error", "登陆失败，账号或者密码错误!");
            return "login";
        } else {
            session.put("user", model);
            return "success";
        }
    }
}
