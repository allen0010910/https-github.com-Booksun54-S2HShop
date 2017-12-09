package main.com.ssh.shop.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "WHLIST")
public class Whlist {
    private int id;
    private Integer type;
    private Integer num;
    private Timestamp date;
    private Integer userid;
    private Double money;

    public Whlist(int id, Integer type, Integer num, Timestamp date, Integer userid, Double money) {
        this.id = id;
        this.type = type;
        this.num = num;
        this.date = date;
        this.userid = userid;
        this.money = money;
    }

    public Whlist() {
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "TYPE", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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


    @Column(name = "USERID", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Whlist{" +
                "id=" + id +
                ", type=" + type +
                ", num=" + num +
                ", date=" + date +
                ", userid=" + userid +
                ", money=" + money +
                '}';
    }

    @Column(name = "MONEY", nullable = true, precision = 0)
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Whlist whlist = (Whlist) o;

        if (id != whlist.id) return false;
        if (type != null ? !type.equals(whlist.type) : whlist.type != null) return false;
        if (num != null ? !num.equals(whlist.num) : whlist.num != null) return false;
        if (date != null ? !date.equals(whlist.date) : whlist.date != null) return false;
        if (userid != null ? !userid.equals(whlist.userid) : whlist.userid != null) return false;
        if (money != null ? !money.equals(whlist.money) : whlist.money != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        return result;
    }
}
