package main.com.ssh.shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "PROVIDER")
public class Provider {
    private int pno;
    private String pname;
    private String phone;
    private String infor;
    private String address;

    public Provider(int pno, String pname, String phone, String infor, String address) {
        this.pno = pno;
        this.pname = pname;
        this.phone = phone;
        this.infor = infor;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Provider{" +
                "pno=" + pno +
                ", pname='" + pname + '\'' +
                ", phone='" + phone + '\'' +
                ", infor='" + infor + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Provider(String pname, String phone, String infor, String address) {
        this.pname = pname;
        this.phone = phone;
        this.infor = infor;
        this.address = address;
    }

    public Provider() {
    }

    @Id
    @GeneratedValue
    @Column(name = "PNO", nullable = false)
    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }



    @Column(name = "PNAME", nullable = true, length = 255)
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


    @Column(name = "PHONE", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Column(name = "INFOR", nullable = true, length = 255)
    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
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

        Provider provider = (Provider) o;

        if (pno != provider.pno) return false;
        if (pname != null ? !pname.equals(provider.pname) : provider.pname != null) return false;
        if (phone != null ? !phone.equals(provider.phone) : provider.phone != null) return false;
        if (infor != null ? !infor.equals(provider.infor) : provider.infor != null) return false;
        if (address != null ? !address.equals(provider.address) : provider.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pno;
        result = 31 * result + (pname != null ? pname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (infor != null ? infor.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
