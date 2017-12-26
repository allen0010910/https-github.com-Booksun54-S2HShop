package main.com.ssh.shop.action;

import main.com.ssh.shop.entity.Stock;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("stockAction")
@Scope("prototype")
public class StockAction {
    private static Logger logger = Logger.getLogger(StockAction.class);

    public String toStock() {
        return "success";
    }
}
