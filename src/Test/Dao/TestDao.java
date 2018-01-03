package Test.Dao;

import com.alibaba.fastjson.JSON;
import main.com.ssh.shop.dao.GoodsDao;
import main.com.ssh.shop.dao.MenuDao;
import main.com.ssh.shop.dao.UserDao;
import main.com.ssh.shop.entity.Goods;
import main.com.ssh.shop.entity.Menu;
import main.com.ssh.shop.entity.User;
import main.com.ssh.shop.service.MenuService;
import main.com.ssh.shop.service.UserService;
import main.com.ssh.shop.util.MenuUtil;
import org.apache.poi.hssf.usermodel.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class TestDao {

    @Resource
    private UserDao userDao;
    @Resource
    private UserService userService;
    @Resource
    private MenuDao menuDao;
    @Resource
    private MenuService menuService;
    @Resource
    private GoodsDao goodsDao;

    private static Logger logger = Logger.getLogger(TestDao.class);


    @Test //测试Hibernate和Spring整合后
    public void testcreate() {
        Configuration conf = new Configuration();

        conf.configure("/hibernate.cfg.xml");

        SchemaExport dbExport = new SchemaExport(conf);

        dbExport.create(true, true);
    }

    @Test //测试Hibernate和Spring整合后
    public void testlogin() {
        User user = userDao.login(new User("root", "123"));
        if (user != null) {
            System.out.println(user.toString());
        }
    }

    @Test //测试Hibernate和Spring整合后
    public void testcreateUser() {
        userDao.save(new User("root", "123"));
        User user = userDao.getUser("root");

    }

    @Test
    public void testgetUser() {
        User user = userDao.getUser("root");
        if (user != null) {
            //System.out.println(user.toString());
            logger.info(user.toString());
        }
    }


    @Test //测试Hibernate和Spring整合后
    public void testloginService() {
        User user = userService.login(new User("root", "1234"));
        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("登录失败!");
        }
    }

    @Test //测试Hibernate和Spring整合后
    public void testMenuALL() {
        List<Menu> query = new ArrayList<Menu>();
        query = menuService.query();

        for (Menu i : query) {
            System.out.println(i.toString());
            logger.info(i.toString());
        }

        List<Menu> query2 = MenuUtil.convertoJson(query);
        String jsonString = JSON.toJSONString(query2);
        logger.info(jsonString);
    }


    @Test //测试Hibernate和Spring整合后
    public void testGoods() {
        //Goods goods = new Goods("皮鞋", "好看的皮鞋", "皮鞋", 123.5);
        //goodsDao.save(goods);
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("表一");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式　
        // 写列名，视自己的需求而定
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("商品名称");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("简介");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("类型");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("价格");
        cell.setCellStyle(style);


        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        List<Goods> exportList = goodsDao.queryToGoods(" ", 0, 0);
        for (int i = 0; i < exportList.size(); i++) {
            row = sheet.createRow((int) i + 1);
            Goods good = exportList.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell(0).setCellValue(good.getName());
            row.createCell(1).setCellValue(good.getSamary());
            row.createCell(2).setCellValue(good.getType());
            row.createCell(3).setCellValue(good.getPrice());
        }
        //自动设置EXCEL的列宽，视自己的需求而定，也可以用sheet.setDefaultColumnWidth(13);为全部列的列宽设置默认值
        sheet.autoSizeColumn((short) 0);
        sheet.autoSizeColumn((short) 2);
        sheet.autoSizeColumn((short) 6);
        sheet.autoSizeColumn((short) 7);
        sheet.autoSizeColumn((short) 8);
        sheet.autoSizeColumn((short) 9);
        sheet.autoSizeColumn((short) 10);
        //设置文件名，用格式化日期来生成一个ID
        String filePath = "";
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = df.format(dt).toString();
        filePath = "G:\\JavaWebProject\\S2HShop\\src\\main\\webapp\\assets\\good" + date + ".xls";
        File file = new File(filePath);
        try {
            OutputStream out = new FileOutputStream(file);
            wb.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
