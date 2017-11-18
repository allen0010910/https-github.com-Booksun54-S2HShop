package main.com.ssh.shop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER" ,uniqueConstraints = {@UniqueConstraint(columnNames = {"userid","password"})})
public class User implements Serializable {
    private String userid;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID" ,unique = true,nullable = false)
    private Integer ID;

    public User(){

    }

    public User(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    @Id
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
