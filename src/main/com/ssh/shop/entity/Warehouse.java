package main.com.ssh.shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "WAREHOUSE")
public class Warehouse {
    private int id;
    private Integer goodid;
    private Integer num;
    private Integer min;

    public Warehouse(Integer goodid, Integer num, Integer min) {
        this.goodid = goodid;
        this.num = num;
        this.min = min;
    }

    public Warehouse(int id, Integer goodid, Integer num, Integer min) {
        this.id = id;
        this.goodid = goodid;
        this.num = num;
        this.min = min;

    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", goodid=" + goodid +
                ", num=" + num +
                ", min=" + min +
                '}';
    }

    public Warehouse() {
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


    @Column(name = "GOODID", nullable = true)
    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }


    @Column(name = "NUM", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    @Column(name = "MIN", nullable = true)
    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warehouse warehouse = (Warehouse) o;

        if (id != warehouse.id) return false;
        if (goodid != null ? !goodid.equals(warehouse.goodid) : warehouse.goodid != null) return false;
        if (num != null ? !num.equals(warehouse.num) : warehouse.num != null) return false;
        if (min != null ? !min.equals(warehouse.min) : warehouse.min != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (goodid != null ? goodid.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (min != null ? min.hashCode() : 0);
        return result;
    }
}
