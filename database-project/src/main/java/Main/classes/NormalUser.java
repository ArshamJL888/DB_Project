package Main.classes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="my_users")
public class NormalUser {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

    @Column(name = "name")
    private String name="کاربر عزیز";

    @Column(name = "fname")
    private String fname="";

    @Column(name = "email")
    private String email="";

    @Column(name = "phone_number")
    private String phoneNumber="";

    public NormalUser() {
    }

    public NormalUser(String name, String fname, String email, String phoneNumber) {
        this.name = name;
        this.fname = fname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public NormalUser(Long userId, String name, String fname, String email, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.fname = fname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public NormalUser(String name, String fname, String email) {
        this.name = name;
        this.fname = fname;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long UserId) {
        this.userId = UserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "NormalUser{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", fname='" + fname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
