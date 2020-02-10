package com.techpeak.customermanagement.dto;

import javax.persistence.Column;
import java.util.Date;

public class RegistrationDto {

    private String name;
    private String surname;
    private String username;
    private String userAccessCode;
    private Date registerDate;
    private String password;
    private int authorizationCode;

    public RegistrationDto() {
    }

    public RegistrationDto(String name, String surname, String username, String userAccessCode, Date registerDate, String password, int authorizationCode) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.userAccessCode = userAccessCode;
        this.registerDate = registerDate;
        this.password = password;
        this.authorizationCode = authorizationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", userAccessCode='" + userAccessCode + '\'' +
                ", registerDate=" + registerDate +
                ", password='" + password + '\'' +
                ", authorizationCode=" + authorizationCode +
                '}';
    }
}
