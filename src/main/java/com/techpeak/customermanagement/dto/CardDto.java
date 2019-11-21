package com.techpeak.customermanagement.dto;

import com.techpeak.customermanagement.entity.CardStatus;
import com.techpeak.customermanagement.entity.CardType;
import com.techpeak.customermanagement.entity.Customers;

import javax.persistence.*;
import java.util.Date;

public class CardDto {
    private String cardNo;
    private CardType cardType;
    private CardStatus cardStatus;
    private Customers customers;

    public CardDto() {
    }

    public CardDto(String cardNo, CardType cardType, CardStatus cardStatus, Customers customers) {
        this.cardNo = cardNo;
        this.cardType = cardType;
        this.cardStatus = cardStatus;
        this.customers = customers;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "CardDto{" +
                "cardNo='" + cardNo + '\'' +
                ", cardType=" + cardType +
                ", cardStatus=" + cardStatus +
                ", customers=" + customers +
                '}';
    }
}
