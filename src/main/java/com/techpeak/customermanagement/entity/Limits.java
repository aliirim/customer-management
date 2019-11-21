package com.techpeak.customermanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "limits")
public class Limits {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="card_type")
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column(name="card_limit")
    private double cardLimit;

    public Limits() {
    }

    public Limits(CardType cardType, double cardLimit) {
        this.cardType = cardType;
        this.cardLimit = cardLimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(double cardLimit) {
        this.cardLimit = cardLimit;
    }

    @Override
    public String toString() {
        return "Limits{" +
                "id=" + id +
                ", cardType=" + cardType +
                ", cardLimit=" + cardLimit +
                '}';
    }
}
