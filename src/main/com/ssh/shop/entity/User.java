package main.com.ssh.shop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {
    private Integer id;
    private String userid;
    private String password;
    private String pic;

    public User(Integer id, String userid, String password, String pic) {
        this.id = id;
        this.userid = userid;
        this.password = password;
        this.pic = pic;
    }

    @Column(name = "PIC", unique = true, nullable = true)
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(Integer ID, String userid, String password) {
        this.id = ID;
        this.userid = userid;
        this.password = password;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID" ,unique = true,nullable = false)
    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(){

    }

    public User(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    @Column(name = "USERID", nullable = false, length = 11)
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    @Column(name = "PASSWORD", nullable = true, length = 15)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userid != null ? !userid.equals(user.userid) : user.userid != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
