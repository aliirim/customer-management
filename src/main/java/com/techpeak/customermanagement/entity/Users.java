package com.techpeak.customermanagement.entity;

import com.techpeak.customermanagement.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="password",length = 10)
    private String Password;

    @Column(name="authorization_code",length = 3)
    private int authorizationCode;

    @Column(name="user_access_code",length = 5)
    private String userAccessCode;

    @Column(name="register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;

    public Users() {
    }

    public Users(String name, String surName, String password, int authorizationCode, String userAccessCode, Date registerDate) {
        super(name, surName);
        Password = password;
        this.authorizationCode = authorizationCode;
        this.userAccessCode = userAccessCode;
        this.registerDate = registerDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(int authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getUserAccessCode() {
        return userAccessCode;
    }

    public void setUserAccessCode(String userAccessCode) {
        this.userAccessCode = userAccessCode;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", Password='" + Password + '\'' +
                ", authorizationCode=" + authorizationCode +
                ", userAccessCode='" + userAccessCode + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
