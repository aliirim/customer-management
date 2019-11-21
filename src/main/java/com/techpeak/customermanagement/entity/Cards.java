package com.techpeak.customermanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cards",indexes = {@Index(name="idx_cardno",columnList = "card_no") })
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="card_no", length = 16, unique = true)
    private String cardNo;

    @Column(name="card_type")
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column(name="card_CVV", length = 3)
    private String cardCVV;

    @Column(name="expire_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;

    @Column(name="card_status")
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    @JoinColumn(name = "customer_no",referencedColumnName = "customer_no")
    @ManyToOne
    private Customers customers;

    public Cards() {
    }

    public Cards(String cardNo, CardType cardType, String cardCVV, Date expireDate, CardStatus cardStatus, Customers customers) {
        this.cardNo = cardNo;
        this.cardType = cardType;
        this.cardCVV = cardCVV;
        this.expireDate = expireDate;
        this.cardStatus = cardStatus;
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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
        return "Cards{" +
                "id=" + id +
                ", cardNo='" + cardNo + '\'' +
                ", cardType=" + cardType +
                ", cardCVV='" + cardCVV + '\'' +
                ", expireDate=" + expireDate +
                ", cardStatus=" + cardStatus +
                ", customers=" + customers +
                '}';
    }
}
