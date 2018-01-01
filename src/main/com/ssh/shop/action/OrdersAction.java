package main.com.ssh.shop.action;

import main.com.ssh.shop.entity.*;
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
        if (page == null || rows == null) {
            page = 0;
            rows = 0;
        }
        pageMap = new HashMap<String, Object>();
        List<Orders> ordersList = ordersService.queryToOrders(page, rows);
        pageMap.put("rows", ordersList);
        Long total = ordersService.getCount();
        pageMap.put("total", total);
        return "jsonMap";
    }

    public void saveOrders() {

        System.out.println("保存:" + model.toString() + "warehouseID:" + model.getWhlist().getId() + "Goods name:" + model.getGoods().getName());
        model.setSum(model.getPrice() * model.getPrice());
        User user = (User) session.get("user");
        model.setUserid(user.getID());
        ordersService.save(model);
    }

    public void deleteOrders() {
        ordersService.delete(model.getId());
    }

    public void editOrders() {
        System.out.println(model.toString());
        Double sum = model.getPrice() * model.getNum();
        ordersService.updateOrders(model.getId(), model.getNum(), model.getPrice(), sum, model.getDate());
    }
}
