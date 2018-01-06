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
        whlistService.updateWlBytype(1, model.getNum(), model.getWhlist().getId());
        ordersService.save(model);
    }

    public void deleteOrders() {
        Orders orders = ordersService.getOrdersByid(model.getId());
        whlistService.updateWlBytype(0, orders.getNum(), orders.getWhlist().getId());
        ordersService.delete(model.getId());
    }

    public void editOrders() {
        System.out.println(model.toString());
        Double sum = model.getPrice() * model.getNum();
        Orders orders = ordersService.getOrdersByid(model.getId());
        int before = orders.getNum();
        //System.out.println("brfore"+before+"after"+model.getNum());
        if (before - model.getNum() != 0) {
            System.out.println("库存更新!");
            if (before - model.getNum() > 0) {
                whlistService.updateWlBytype(0, before - model.getNum(), model.getWhlist().getId());
            } else {

                whlistService.updateWlBytype(1, model.getNum() - before, model.getWhlist().getId());
            }
        }
        ordersService.updateOrders(model.getId(), model.getNum(), model.getPrice(), sum, model.getDate());
    }

    public String searchbyid() {
        pageMap = new HashMap<String, Object>();

        //根据关键字和分页的参数查询相应的数据。这个方法在Service中写过了，完成级联查询
        //System.out.println("page:"+page+"rows:"+rows+"model:"+model.toString());
        //System.out.println("商品名称:"+model.getGoods().getName());
        if (model.getId() == 0)
            if (model.getGoods() != null) {
                System.out.println("得到名字:" + model.getGoods().getName());
            }
        List<Orders> ordersList = ordersService.searchbyid(model.getId(), page, rows);
        pageMap.put("rows", ordersList); //存储为JSON格式，从上一节的json文件可以看出，一个key是total,一个key是rows，这里先把rows存放好
        //根据关键字查询总记录数
        Long total = ordersService.getCount(model.getId());
//      System.out.println(total);
        pageMap.put("total", total); //存储为JSON格式，再把total存放好

        return "jsonMap";
    }
}
