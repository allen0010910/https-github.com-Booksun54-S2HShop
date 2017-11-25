package main.com.ssh.shop.action;


import com.alibaba.fastjson.JSON;
import main.com.ssh.shop.entity.Menu;
import main.com.ssh.shop.util.MenuUtil;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("menuAction")
@Scope("prototype")
public class MenuAction extends BaseAction<Menu> {

    private static Logger logger = Logger.getLogger(MenuAction.class);


    public String getMenu() {
        jsonList = MenuUtil.convertoJson(menuService.getAllMenu());
        String jsonString = JSON.toJSONString(jsonList);
        System.out.println(jsonString);
        return "jsonList";
    }

}
