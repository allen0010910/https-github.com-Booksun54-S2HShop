package main.com.ssh.shop.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ORDER")
public class Order {
    private int id;
    private Integer goodsid;
    private Integer num;
    private Timestamp date;
    private Double price;
    private Integer userid;

    public Order(int id, Integer goodsid, Integer num, Timestamp date, Double price, Integer userid) {
        this.id = id;
        this.goodsid = goodsid;
        this.num = num;
        this.date = date;
        this.price = price;
        this.userid = userid;
    }

    public Order(Integer goodsid, Integer num, Timestamp date, Double price, Integer userid) {
        this.goodsid = goodsid;
        this.num = num;
        this.date = date;
        this.price = price;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goodsid=" + goodsid +
                ", num=" + num +
                ", date=" + date +
                ", price=" + price +
                ", userid=" + userid +
                '}';
    }

    public Order() {
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "GOODSID", nullable = true)
    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }


    @Column(name = "NUM", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    @Column(name = "DATE", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    @Column(name = "PRICE", nullable = true, precision = 2)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

        Order order = (Order) o;

        if (id != order.id) return false;
        if (goodsid != null ? !goodsid.equals(order.goodsid) : order.goodsid != null) return false;
        if (num != null ? !num.equals(order.num) : order.num != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        if (userid != null ? !userid.equals(order.userid) : order.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (goodsid != null ? goodsid.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }
}
