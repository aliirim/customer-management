package com.techpeak.customermanagement.dto;

import com.techpeak.customermanagement.entity.TransactionType;

public class TransactionDto {
    private int id;
    private TransactionType transactionType;
    private double fee;
    private String description;
    private CardDto cardDto;

    public TransactionDto() {
    }

    public TransactionDto(int id, TransactionType transactionType, double fee, String description, CardDto cardDto) {
        this.id = id;
        this.transactionType = transactionType;
        this.fee = fee;
        this.description = description;
        this.cardDto = cardDto;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CardDto getCardDto() {
        return cardDto;
    }

    public void setCardDto(CardDto cardDto) {
        this.cardDto = cardDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", transactionType=" + transactionType +
                ", fee=" + fee +
                ", description='" + description + '\'' +
                ", cardDto=" + cardDto +
                '}';
    }
}
