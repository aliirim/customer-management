package com.techpeak.customermanagement.entity;

import com.techpeak.customermanagement.entity.Cards;
import com.techpeak.customermanagement.entity.TransactionType;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name="fee")
    private double fee;

    @Column(name="description",length = 100)
    private String description;

    @Column(name="store_adress",length = 100)
    private String storeAdress;

    @ManyToOne
    @JoinColumn(name = "card_no",referencedColumnName = "card_no")
    private Cards cards;

    public Transactions() {
    }

    public Transactions(TransactionType transactionType, double fee, String description, String storeAdress, Cards cards) {
        this.transactionType = transactionType;
        this.fee = fee;
        this.description = description;
        this.storeAdress = storeAdress;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStoreAdress() {
        return storeAdress;
    }

    public void setStoreAdress(String storeAdress) {
        this.storeAdress = storeAdress;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", transactionType=" + transactionType +
                ", fee=" + fee +
                ", description='" + description + '\'' +
                ", storeAdress='" + storeAdress + '\'' +
                ", cards=" + cards +
                '}';
    }
}
