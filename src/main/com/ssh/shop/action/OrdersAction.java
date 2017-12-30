package main.com.ssh.shop.action;

import main.com.ssh.shop.entity.Orders;
import main.com.ssh.shop.entity.Stock;
import main.com.ssh.shop.service.OrdersService;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

@Controller("ordersAction")
@Scope("prototype")
public class OrdersAction extends BaseAction<Orders> {

    private static Logger logger = Logger.getLogger(OrdersAction.class);

    public String toOrders() {
        return "success";
    }

    public String queryOrders() {
        //用来存储分页的数据
        pageMap = new HashMap<String, Object>();
        List<Orders> ordersList = ordersService.queryToOrders(page, rows);
        pageMap.put("rows", ordersList);
        Long total = ordersService.getCount();
        pageMap.put("total", total);
        return "jsonMap";
    }
}
