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

    public String pwd() {
        return "pwd";
    }

    public String headPortrait() {
        return "headPortrait";
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
        pageMap = new HashMap<String, Object>();
        if(user!=null){
            //session.put("useriderror", "用户名已存在！");
            pageMap.put("tip", "管理员已存在!");
            pageMap.put("check", false);
        }else{
            model.setPic("pic\\71c42a9c-1338-4734-8845-94e7c98d1b22.jpg");
            userService.save(model);
            pageMap.put("tip", "管理员添加成功!");
            pageMap.put("check", true);

        }
        return "jsonMap";
    }

    public String changeImage() {
        //fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
        String pic = fileUpload.uploadFile(fileImage);
        System.out.println(fileImage.getFile().getName());
        User user = (User) session.get("user");
        System.out.println(user.toString());
        user.setPic("pic\\" + pic);
        System.out.println(user.toString());
        //商品信息入库
        userService.update(user);
        return "success";
    }

    public String updatepwd() {
        pageMap = new HashMap<String, Object>();
        try {
            User user = (User) session.get("user");
            user.setPassword(model.getPassword());
            userService.update(user);
            pageMap.put("tip", "修改密码成功!");
            pageMap.put("check", true);
        } catch (Exception e) {
            pageMap.put("tip", "修改密码失败!");
            pageMap.put("check", false);
        }
        return "jsonMap";
    }

    public String logout() {
        session.remove("user");
        return "login";
    }



}
