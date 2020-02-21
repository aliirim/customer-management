package com.techpeak.customermanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "authorization_code", length = 3)
    private int authorizationCode;

    @Column(name = "user_access_code", length = 5)
    private String userAccessCode;

    @Column(name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;

    public Users() {
    }

    public Users(String name, String surName, String username, String password, int authorizationCode, String userAccessCode, Date registerDate) {
        super(name, surName);
        this.username = username;
        this.password = password;
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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorizationCode=" + authorizationCode +
                ", userAccessCode='" + userAccessCode + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
