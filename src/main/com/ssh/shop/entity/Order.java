package main.com.ssh.shop.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ORDER")
public class Order {
    private int id;
    private Integer goodsid;
    private Integer num;
    private Timestamp data;
    private Double price;
    private Integer userid;
    private Integer pno;
    private Double sum;

    public Order() {

    }

    @Id
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


    @Column(name = "DATA", nullable = true)
    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }


    @Column(name = "PRICE", nullable = true, precision = 0)
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


    @Column(name = "PNO", nullable = true)
    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goodsid=" + goodsid +
                ", num=" + num +
                ", data=" + data +
                ", price=" + price +
                ", userid=" + userid +
                ", pno=" + pno +
                ", sum=" + sum +
                '}';
    }

    public Order(int id, Integer goodsid, Integer num, Timestamp data, Double price, Integer userid, Integer pno, Double sum) {
        this.id = id;
        this.goodsid = goodsid;
        this.num = num;
        this.data = data;
        this.price = price;
        this.userid = userid;
        this.pno = pno;
        this.sum = sum;
    }

    @Column(name = "SUM", nullable = true, precision = 0)

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (goodsid != null ? !goodsid.equals(order.goodsid) : order.goodsid != null) return false;
        if (num != null ? !num.equals(order.num) : order.num != null) return false;
        if (data != null ? !data.equals(order.data) : order.data != null) return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        if (userid != null ? !userid.equals(order.userid) : order.userid != null) return false;
        if (pno != null ? !pno.equals(order.pno) : order.pno != null) return false;
        if (sum != null ? !sum.equals(order.sum) : order.sum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (goodsid != null ? goodsid.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (pno != null ? pno.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        return result;
    }
}
