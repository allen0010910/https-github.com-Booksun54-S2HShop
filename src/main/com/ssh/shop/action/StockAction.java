package main.com.ssh.shop.action;

import main.com.ssh.shop.entity.Stock;
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
        pageMap = new HashMap<String, Object>();
        List<Stock> stockList = stockService.queryToStock(page, rows);
        pageMap.put("rows", stockList);
        Long total = stockService.getCount();
        pageMap.put("total", total);
        return "jsonMap";
    }

}

