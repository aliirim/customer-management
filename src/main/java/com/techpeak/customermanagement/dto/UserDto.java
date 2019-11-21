package com.techpeak.customermanagement.dto;

import com.techpeak.customermanagement.entity.UserDetails;

import javax.persistence.*;
import java.util.Date;

public class UserDto {

    private int id;
    private String name;
    private String surname;
    private String userAccessCode;
    private Date registerDate;
    private UserDetailDto userDetailDto;

    public UserDto() {
    }

    public UserDto(int id, String name, String surname, String userAccessCode, Date registerDate, UserDetailDto userDetailDto) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.userAccessCode = userAccessCode;
        this.registerDate = registerDate;
        this.userDetailDto = userDetailDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserDetailDto getUserDetailDto() {
        return userDetailDto;
    }

    public void setUserDetailDto(UserDetailDto userDetailDto) {
        this.userDetailDto = userDetailDto;
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

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", userAccessCode='" + userAccessCode + '\'' +
                ", registerDate=" + registerDate +
                ", userDetailDto=" + userDetailDto +
                '}';
    }
}
