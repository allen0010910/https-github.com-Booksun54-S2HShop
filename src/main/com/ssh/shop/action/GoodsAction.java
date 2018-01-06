package main.com.ssh.shop.action;

import main.com.ssh.shop.entity.Goods;
import main.com.ssh.shop.entity.Whlist;
import main.com.ssh.shop.service.GoodsService;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class GoodsAction extends BaseAction<Goods> {

    private static Logger logger = Logger.getLogger(GoodsAction.class);

    public String toGoods() {
        return "success";
    }

    public String queryGoods() {
        //用来存储分页的数据
        pageMap = new HashMap<String, Object>();

        //根据关键字和分页的参数查询相应的数据。这个方法在Service中写过了，完成级联查询
        //System.out.println("page:"+page+"rows:"+rows+"model:"+model.toString())
        if (page == null || rows == null) {
            page = 0;
            rows = 0;
        }
        List<Goods> providerList = goodsService.queryToGoods(model.getName(), page, rows);
        pageMap.put("rows", providerList); //存储为JSON格式，从上一节的json文件可以看出，一个key是total,一个key是rows，这里先把rows存放好
        //根据关键字查询总记录数
        Long total = goodsService.getCount(model.getName()); //
//      System.out.println(total);
        pageMap.put("total", total); //存储为JSON格式，再把total存放好

        return "jsonMap";
    }

    public void deletegoods() {
        goodsService.delete(model.getId());
    }

    public String saveGoods() throws Exception {
        //fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
        if (fileImage != null && !fileImage.equals(" ")) {
            String pic = fileUpload.uploadFile(fileImage);
            System.out.println(fileImage.getFile().getName());

            System.out.println();
            model.setPic("pic\\" + pic);
            System.out.println(model.toString());
        } else {
            model.setPic(null);
        }
        //商品信息入库
        goodsService.save(model);
        return "toGoods";
    }

    public String updateGoods() {
        System.out.println(fileImage);
        if (fileImage != null && !fileImage.equals(" ")) {
            String pic = fileUpload.uploadFile(fileImage);
            model.setPic("pic\\" + pic);
            System.out.println(model);
            //更新商品
            goodsService.update(model);
        } else {
            goodsService.updateGoods(model.getId(), model.getName(), model.getSamary(), model.getPrice(), model.getType());
        }

        return "toGoods";
    }


}
