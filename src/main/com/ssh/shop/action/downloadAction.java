package main.com.ssh.shop.action;

import main.com.ssh.shop.entity.Goods;
import main.com.ssh.shop.entity.Stock;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class downloadAction extends BaseAction<Goods> {

    private static Logger logger = Logger.getLogger(downloadAction.class);


    public String exportNetworkDeviceList() {
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
        List<Goods> exportList = goodsService.queryToGoods(" ", 0, 0);
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

        //第七步，将文件存到流中
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            wb.write(os);
            byte[] fileContent = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
            String filePath = "";
            Date dt = new Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = df.format(dt).toString();
            filePath = "good" + date + ".xls";
            excelStream = is;             //文件流
            excelFileName = filePath; //设置下载的文件名
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    public String exportStockList() {
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
        cell.setCellValue("仓库");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("商品");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("销售数量");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("销售价格");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("销售金额");
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellValue("时间");
        cell.setCellStyle(style);


        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        List<Stock> exportList = stockService.queryToStock();
        for (int i = 0; i < exportList.size(); i++) {
            row = sheet.createRow((int) i + 1);
            Stock stock = exportList.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell(0).setCellValue(stock.getWhlist().getWarehouse().getName());
            row.createCell(1).setCellValue(stock.getGoods().getName());
            row.createCell(2).setCellValue(stock.getNum());
            row.createCell(3).setCellValue(stock.getSellprice());
            row.createCell(4).setCellValue(stock.getMoney());
            row.createCell(5).setCellValue(stock.getDate());


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

        //第七步，将文件存到流中
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            wb.write(os);
            byte[] fileContent = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
            String filePath = "";
            Date dt = new Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = df.format(dt).toString();
            filePath = "stock" + date + ".xls";
            excelStream = is;             //文件流
            excelFileName = filePath; //设置下载的文件名
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    private InputStream excelStream;  //输出流变量
    private String excelFileName; //下载文件名

    public InputStream getExcelStream() {
        return excelStream;
    }

    public void setExcelStream(InputStream excelStream) {
        this.excelStream = excelStream;
    }

    public String getExcelFileName() {
        return excelFileName;
    }

    public void setExcelFileName(String excelFileName) {
        this.excelFileName = excelFileName;
    }

}
