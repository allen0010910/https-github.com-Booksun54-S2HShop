package main.com.ssh.shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "GOODS")
public class Goods {
    private int id;
    private String name;
    private String pic;
    private String samary;
    private String type;
    private Double price;


    public Goods(String name, String samary, String type, Double price) {
        this.name = name;
        this.samary = samary;
        this.type = type;
        this.price = price;
    }

    public Goods() {

    }

    public Goods(String name, String pic, String samary, String type, Double price) {
        this.name = name;
        this.pic = pic;
        this.samary = samary;
        this.type = type;
        this.price = price;

    }

    public Goods(int id, String name, String pic, String samary, String type, Double price) {

        this.id = id;
        this.name = name;
        this.pic = pic;
        this.samary = samary;
        this.type = type;
        this.price = price;
    }

    public Goods(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "NAME", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "PIC", nullable = true, length = 255)
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


    @Column(name = "SAMARY", nullable = true, length = 255)
    public String getSamary() {
        return samary;
    }

    public void setSamary(String samary) {
        this.samary = samary;
    }


    @Column(name = "TYPE", nullable = true, length = 11)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", samary='" + samary + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    @Column(name = "PRICE", nullable = true, precision = 2)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (pic != null ? !pic.equals(goods.pic) : goods.pic != null) return false;
        if (samary != null ? !samary.equals(goods.samary) : goods.samary != null) return false;
        if (type != null ? !type.equals(goods.type) : goods.type != null) return false;
        if (price != null ? !price.equals(goods.price) : goods.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (samary != null ? samary.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
