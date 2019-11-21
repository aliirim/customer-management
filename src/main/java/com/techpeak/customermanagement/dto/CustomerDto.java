package com.techpeak.customermanagement.dto;

import com.techpeak.customermanagement.entity.Cards;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class CustomerDto {
    private String name;
    private String surname;
    private String customerNo;
    private String mobilTel;
    private String profession;
    private List<CardDto> cardDtos;

    public CustomerDto() {
    }

    public CustomerDto(String name, String surname, String customerNo, String mobilTel, String profession, List<CardDto> cardDtos) {
        this.name = name;
        this.surname = surname;
        this.customerNo = customerNo;
        this.mobilTel = mobilTel;
        this.profession = profession;
        this.cardDtos = cardDtos;
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

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getMobilTel() {
        return mobilTel;
    }

    public void setMobilTel(String mobilTel) {
        this.mobilTel = mobilTel;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<CardDto> getCardDtos() {
        return cardDtos;
    }

    public void setCardDtos(List<CardDto> cardDtos) {
        this.cardDtos = cardDtos;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", mobilTel='" + mobilTel + '\'' +
                ", profession='" + profession + '\'' +
                ", cardDtos=" + cardDtos +
                '}';
    }
}
