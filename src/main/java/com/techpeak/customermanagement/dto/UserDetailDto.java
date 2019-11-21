package com.techpeak.customermanagement.dto;

import com.techpeak.customermanagement.entity.Users;

public class UserDetailDto {
    private String email;
    private String address1;
    private String address2;
    private String address3;
    private String mobilTel;
    private Users user;

    public UserDetailDto() {
    }

    public UserDetailDto(String email, String address1, String address2, String address3, String mobilTel, Users user) {
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.mobilTel = mobilTel;
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getMobilTel() {
        return mobilTel;
    }

    public void setMobilTel(String mobilTel) {
        this.mobilTel = mobilTel;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDetailDto{" +
                "email='" + email + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", mobilTel='" + mobilTel + '\'' +
                ", user=" + user +
                '}';
    }
}
