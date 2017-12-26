package main.com.ssh.shop.action;

import main.com.ssh.shop.entity.Whlist;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;


@Controller("whlistAction")
@Scope("prototype")
public class WhlistAction extends BaseAction<Whlist> {
    private static Logger logger = Logger.getLogger(WarehosueAction.class);

    private int wno;//仓库ID

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        WhlistAction.logger = logger;
    }

    public int getWno() {
        return wno;
    }

    public void setWno(int wno) {
        this.wno = wno;
    }

    public String toWhlist() {

        pageMap = new HashMap<String, Object>();
        wno = model.getWno();
        request.put("wno", wno);
        System.out.println("得到仓库ID:" + wno);
        pageMap.put("wno", model.getWno());
        return "success";
    }

    public String queryWhlist() {
        //用来存储分页的数据
        pageMap = new HashMap<String, Object>();

        //根据关键字和分页的参数查询相应的数据。这个方法在Service中写过了，完成级联查询
        //System.out.println("page:"+page+"rows:"+rows+"model:"+model.toString());
        //System.out.println("商品名称:"+model.getGoods().getName());
        if (model.getGoods() != null) {
            System.out.println("得到名字:" + model.getGoods().getName());
        }
        List<Whlist> whlistList = whlistService.queryToWhlist(model.getWno(), page, rows);
        pageMap.put("rows", whlistList); //存储为JSON格式，从上一节的json文件可以看出，一个key是total,一个key是rows，这里先把rows存放好
        //根据关键字查询总记录数
        Long total = whlistService.getCountAll(model.getWno()); //
//      System.out.println(total);
        pageMap.put("total", total); //存储为JSON格式，再把total存放好

        return "jsonMap";
    }

    public String searchbyname() {
        pageMap = new HashMap<String, Object>();

        //根据关键字和分页的参数查询相应的数据。这个方法在Service中写过了，完成级联查询
        //System.out.println("page:"+page+"rows:"+rows+"model:"+model.toString());
        //System.out.println("商品名称:"+model.getGoods().getName());
        if (model.getGoods() != null) {
            System.out.println("得到名字:" + model.getGoods().getName());
        }
        List<Whlist> whlistList = whlistService.searchbyname(model.getGoods().getName(), model.getWno(), page, rows);
        pageMap.put("rows", whlistList); //存储为JSON格式，从上一节的json文件可以看出，一个key是total,一个key是rows，这里先把rows存放好
        //根据关键字查询总记录数
        Long total = whlistService.getCountAll(model.getWno()); //
//      System.out.println(total);
        pageMap.put("total", total); //存储为JSON格式，再把total存放好

        return "jsonMap";
    }

    public void deleteWhlist() {
        whlistService.deleteWhlist(model.getId());
    }

}
