package main.com.ssh.shop.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import main.com.ssh.shop.entity.User;
import main.com.ssh.shop.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    private static Logger logger = Logger.getLogger(UserAction.class);

    private String tip;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String register()
    {
        return "register";
    }

    public String update() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
        System.out.println("id" + id);
        System.out.println("---update---");
        System.out.println("model" + model);
        userService.update(model);
        logger.info("---完成用户信息更新---");
        return "index";
    }

    public String save() {
        System.out.println("---save---");
        System.out.println(model.toString());
        userService.save(model);
        logger.info("---完成用户信息插入---");
        return "index";
    }

    public String query() {
        request.put("userList", userService.query());
        session.put("userList", userService.query());
        application.put("userList", userService.query());
        logger.info("---完成用户列表查询---");
        return "index";
    }

    public String toMain() {
        User user = (User) session.get("user");
        System.out.println("session:" + user.toString());
        if (user != null)
            return "success";
        else {
            return "error";
        }
    }

    public String login() {
        System.out.println("进入登陆!");
        //System.out.println(model.toString());
        if (model.getUserid() == null || model.getUserid().equals("") && model.getPassword() != null && !model.getPassword().equals("")) {

            tip = "账号不得为空!";
            System.out.println("账号不得为空!");
            return "error";
        } else if (model.getPassword() == null || model.getPassword().equals("") && model.getUserid() != null && !model.getUserid().equals("")) {

            tip = "密码不得为空!";
            System.out.println("密码不得为空!");
            return "error";
        } else if (model.getPassword() == null || model.getPassword().equals("") || model.getUserid() == null || model.getUserid().equals("")) {
            tip = "账号、密码不得为空!";
            return "error";
        }


        model = userService.login(model);
        //System.out.println(model.toString() + "登录信息");
        if (model == null) {
            tip = "登陆失败，账号或者密码错误!";
            logger.info("===登录失败，账号或者密码错误!===");
            return "login";
        } else {
            session.put("user", model);
            logger.info("===登陆成功!" + model.toString() + "===");
            if (session.get("goURL") == null) {
                return "success"; //跳到首页
            } else {
                return "goURL";
            }

        }
    }

    public String confirmation(){
        User user = userService.getUser(model.getUserid());
        if(user!=null){
            session.put("useriderror", "用户名已存在！");
            return "register";
        }else{
            userService.save(model);
            return "success";
        }
    }

}
