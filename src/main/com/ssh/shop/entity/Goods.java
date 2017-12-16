package main.com.ssh.shop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GOODS")
public class Goods implements Serializable {
    private int goodsid;
    private String name;
    private String type;
    private String samary;
    private String pic;

    public Goods(int goodsid, String name, String type, String samary, String pic) {
        this.goodsid = goodsid;
        this.name = name;
        this.type = type;
        this.samary = samary;
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsid=" + goodsid +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", samary='" + samary + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }

    public Goods(String name, String type, String samary, String pic) {
        this.name = name;
        this.type = type;
        this.samary = samary;
        this.pic = pic;
    }

    public Goods(String name, String type, String samary) {

        this.name = name;
        this.type = type;
        this.samary = samary;
    }

    public Goods() {
    }

    @Id
    @GeneratedValue
    @Column(name = "GOODSID", nullable = false)
    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }


    @Column(name = "NAME", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "TYPE", nullable = true, length = 11)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Column(name = "SAMARY", nullable = true, length = 255)
    public String getSamary() {
        return samary;
    }

    public void setSamary(String samary) {
        this.samary = samary;
    }


    @Column(name = "PIC", nullable = true, length = 255)
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (goodsid != goods.goodsid) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (type != null ? !type.equals(goods.type) : goods.type != null) return false;
        if (samary != null ? !samary.equals(goods.samary) : goods.samary != null) return false;
        if (pic != null ? !pic.equals(goods.pic) : goods.pic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodsid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (samary != null ? samary.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        return result;
    }
}
