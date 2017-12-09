package main.com.ssh.shop.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "STOCK")
public class Stock {
    private int id;
    private Date date;
    private Double price;
    private Double sellprice;
    private String samary;
    private Integer num;
    private Integer goodsid;
    private Double money;
    private Integer userid;

    public Stock(int id, Date date, Double price, Double sellprice, String samary, Integer num, Integer goodsid, Double money, Integer userid) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.sellprice = sellprice;
        this.samary = samary;
        this.num = num;
        this.goodsid = goodsid;
        this.money = money;
        this.userid = userid;
    }

    public Stock(Date date, Double price, Double sellprice, String samary, Integer num, Integer goodsid, Double money, Integer userid) {
        this.date = date;
        this.price = price;
        this.sellprice = sellprice;
        this.samary = samary;
        this.num = num;
        this.goodsid = goodsid;
        this.money = money;
        this.userid = userid;
    }

    public Stock() {

    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "DATE", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Column(name = "PRICE", nullable = true, precision = 2)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Column(name = "SELLPRICE", nullable = true, precision = 2)
    public Double getSellprice() {
        return sellprice;
    }

    public void setSellprice(Double sellprice) {
        this.sellprice = sellprice;
    }


    @Column(name = "SAMARY", nullable = true, length = 255)
    public String getSamary() {
        return samary;
    }

    public void setSamary(String samary) {
        this.samary = samary;
    }


    @Column(name = "NUM", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    @Column(name = "GOODSID", nullable = true)
    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }


    @Column(name = "MONEY", nullable = true, precision = 0)
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }


    @Column(name = "USERID", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (id != stock.id) return false;
        if (date != null ? !date.equals(stock.date) : stock.date != null) return false;
        if (price != null ? !price.equals(stock.price) : stock.price != null) return false;
        if (sellprice != null ? !sellprice.equals(stock.sellprice) : stock.sellprice != null) return false;
        if (samary != null ? !samary.equals(stock.samary) : stock.samary != null) return false;
        if (num != null ? !num.equals(stock.num) : stock.num != null) return false;
        if (goodsid != null ? !goodsid.equals(stock.goodsid) : stock.goodsid != null) return false;
        if (money != null ? !money.equals(stock.money) : stock.money != null) return false;
        if (userid != null ? !userid.equals(stock.userid) : stock.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (sellprice != null ? sellprice.hashCode() : 0);
        result = 31 * result + (samary != null ? samary.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (goodsid != null ? goodsid.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }
}
