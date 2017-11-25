package main.com.ssh.shop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MENU")
public class Menu implements Serializable {
    private int id;
    private String tit;
    private Integer parent;
    private String url;
    private String icon;
    private List<Menu> submenu;

    public Menu() {
        this.submenu = new ArrayList<Menu>();
    }


    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", tit='" + tit + '\'' +
                ", parent=" + parent +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Transient
    public List<Menu> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<Menu> submenu) {
        this.submenu = submenu;
    }


    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TIT", nullable = true)
    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    @Basic
    @Column(name = "PARENT", nullable = true)
    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Basic
    @Column(name = "URL", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "ICON", nullable = true, length = 255)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (id != menu.id) return false;
        if (tit != null ? !tit.equals(menu.tit) : menu.tit != null) return false;
        if (parent != null ? !parent.equals(menu.parent) : menu.parent != null) return false;
        if (url != null ? !url.equals(menu.url) : menu.url != null) return false;
        if (icon != null ? !icon.equals(menu.icon) : menu.icon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tit != null ? tit.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        return result;
    }
}
