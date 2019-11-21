package com.techpeak.customermanagement.dto;

import javax.persistence.Column;
import java.util.Date;

public class RegistrationDto {

    private String name;
    private String surname;
    private String userAccessCode;
    private Date registerDate;
    private String Password;
    private int authorizationCode;

    public RegistrationDto() {
    }

    public RegistrationDto(String name, String surname, String userAccessCode, Date registerDate,  String password, int authorizationCode) {
        this.name = name;
        this.surname = surname;
        this.userAccessCode = userAccessCode;
        this.registerDate = registerDate;
        Password = password;
        this.authorizationCode = authorizationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", userAccessCode='" + userAccessCode + '\'' +
                ", registerDate=" + registerDate +
                ", Password='" + Password + '\'' +
                ", authorizationCode=" + authorizationCode +
                '}';
    }
}
