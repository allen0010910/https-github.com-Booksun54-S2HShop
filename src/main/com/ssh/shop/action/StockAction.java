package main.com.ssh.shop.action;

import main.com.ssh.shop.entity.Goods;
import main.com.ssh.shop.entity.Stock;
import main.com.ssh.shop.entity.User;
import main.com.ssh.shop.entity.Warehouse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

@Controller("stockAction")
@Scope("prototype")
public class StockAction extends BaseAction<Stock> {
    private static Logger logger = Logger.getLogger(StockAction.class);

    public String toStock() {
        return "success";
    }

    public String queryStock() {
        //用来存储分页的数据
        if (page == null || rows == null) {
            page = 0;
            rows = 0;
        }
        pageMap = new HashMap<String, Object>();
        List<Stock> stockList = stockService.queryToStock(page, rows);
        pageMap.put("rows", stockList);
        Long total = stockService.getCount();
        pageMap.put("total", total);
        return "jsonMap";
    }

    public void saveStock() {

        try {
            System.out.println("保存:" + model.toString() + "warehouseID:" + model.getWhlist().getId() + "Goods name:" + model.getGoods().getId());
            System.out.println(model.toString());
            model.setMoney(model.getSellprice() * model.getNum());
            User user = (User) session.get("user");
            System.out.println("用户id" + user.toString());
            model.setUserid(user.getID());
            whlistService.updateWlBytype(0, model.getNum(), model.getWhlist().getId());
            stockService.save(model);
        } catch (Exception e) {

        }
    }

    public void deleteStock() {
        Stock stock = stockService.getStockByid(model.getId());
        whlistService.updateWlBytype(1, stock.getNum(), stock.getWhlist().getId());
        stockService.delete(model.getId());
    }

    public void editStock() {
        System.out.println(model.toString());
        Double money = model.getSellprice() * model.getNum();
        Stock stock = stockService.getStockByid(model.getId());
        int before = stock.getNum();
        //System.out.println("brfore"+before+"after"+model.getNum());
        if (before - model.getNum() != 0) {
            System.out.println("库存更新!");
            if (before - model.getNum() > 0) {
                whlistService.updateWlBytype(1, before - model.getNum(), model.getWhlist().getId());
            } else {
                whlistService.updateWlBytype(0, model.getNum() - before, model.getWhlist().getId());
            }
        }
        stockService.updateStock(model.getId(), model.getNum(), model.getSellprice(), money, model.getDate());
    }
}

