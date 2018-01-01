package main.com.ssh.shop.action;


import main.com.ssh.shop.entity.Warehouse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

@Controller("warehouseAction")
@Scope("prototype")
public class WarehosueAction extends BaseAction<Warehouse> {

    private static Logger logger = Logger.getLogger(WarehosueAction.class);

    public String toWarehouse() {
        return "success";
    }

    public String queryWarehouse() {
        //用来存储分页的数据
        pageMap = new HashMap<String, Object>();
        if (page == null || rows == null) {
            page = 0;
            rows = 0;
        }
        //根据关键字和分页的参数查询相应的数据。这个方法我们在Service中写过了，当时完成级联查询
        //System.out.println("page:"+page+"rows:"+rows+"model:"+model.toString());
        List<Warehouse> warehousesList = warehouseService.queryToWarehouse(model.getName(), page, rows);
        pageMap.put("rows", warehousesList); //存储为JSON格式，从上一节的json文件可以看出，一个key是total,一个key是rows，这里先把rows存放好
        //根据关键字查询总记录数
        Long total = warehouseService.getCount(model.getName()); //
//      System.out.println(total);
        pageMap.put("total", total); //存储为JSON格式，再把total存放好

        return "jsonMap";
    }


    public void saveWarehouse() {
        logger.info("添加供应商信息" + model.toString());
        warehouseService.save(model);
    }

    public String deleteWarehouse() {

        logger.info("删除供应商pno:" + model.getId());
        warehouseService.deleteWarehouse(model.getId());
        Warehouse Warehouse = warehouseService.get(model.getId());
        pageMap = new HashMap<String, Object>();
        if (Warehouse == null) {
            pageMap.put("status", "删除仓库信息成功!");
        } else {
            pageMap.put("status", "删除仓库信息失败!");
        }
        return "jsonMap";
    }

    public String editWarehouse() {
        logger.info("修改供应商pno:" + model.toString());
        try {
            warehouseService.update(model);
            pageMap = new HashMap<String, Object>();
            pageMap.put("status", "修改供应商信息成功!");
        } catch (Exception e) {
            pageMap.put("status", "修改供应商信息失败!");
        }

        return "jsonMap";
    }

}
