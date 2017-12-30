package main.com.ssh.shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "WAREHOUSE")
public class Warehouse {
    private int id;
    private String name;
    private String address;


    public Warehouse() {

    }

    public Warehouse(int id) {
        this.id = id;
    }

    public Warehouse(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Column(name = "NAME", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "ADDRESS", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warehouse warehouse = (Warehouse) o;

        if (id != warehouse.id) return false;
        if (name != null ? !name.equals(warehouse.name) : warehouse.name != null) return false;
        if (address != null ? !address.equals(warehouse.address) : warehouse.address != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);

        return result;
    }
}
