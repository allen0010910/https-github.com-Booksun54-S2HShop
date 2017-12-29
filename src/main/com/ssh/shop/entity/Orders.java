package main.com.ssh.shop.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ORDERS")
public class Orders {
    private int id;
    private Integer goodsid;
    private Integer num;
    private Timestamp date;
    private Double price;
    private Integer userid;
    private Integer pno;
    private Double sum;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "GOODSID", nullable = true)
    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    @Basic
    @Column(name = "NUM", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "DATE", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "PRICE", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "USERID", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "PNO", nullable = true)
    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
    }

    @Basic
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

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (goodsid != null ? !goodsid.equals(orders.goodsid) : orders.goodsid != null) return false;
        if (num != null ? !num.equals(orders.num) : orders.num != null) return false;
        if (date != null ? !date.equals(orders.date) : orders.date != null) return false;
        if (price != null ? !price.equals(orders.price) : orders.price != null) return false;
        if (userid != null ? !userid.equals(orders.userid) : orders.userid != null) return false;
        if (pno != null ? !pno.equals(orders.pno) : orders.pno != null) return false;
        if (sum != null ? !sum.equals(orders.sum) : orders.sum != null) return false;

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
        result = 31 * result + (pno != null ? pno.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        return result;
    }

    public Orders() {

    }

    public Orders(int id, Integer goodsid, Integer num, Timestamp date, Double price, Integer userid, Integer pno, Double sum) {
        this.id = id;
        this.goodsid = goodsid;
        this.num = num;
        this.date = date;
        this.price = price;
        this.userid = userid;
        this.pno = pno;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", goodsid=" + goodsid +
                ", num=" + num +
                ", date=" + date +
                ", price=" + price +
                ", userid=" + userid +
                ", pno=" + pno +
                ", sum=" + sum +
                '}';
    }
}
