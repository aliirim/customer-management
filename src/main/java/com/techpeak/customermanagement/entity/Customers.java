package com.techpeak.customermanagement.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers", indexes = {@Index(name = "idx_customerno", columnList = "customer_no")})
public class Customers extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "customer_no", length = 20, unique = true)
    private String customerNo;

    @Column(name = "mobil_tel", length = 14)
    private String mobilTel;

    @Column(name = "work_tel", length = 14)
    private String workTel;

    @Column(name = "profession", length = 20)
    private String profession;

    @Column(name = "record_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;

    @OneToMany(mappedBy = "customers")
    private List<Cards> cards;

    public Customers() {
    }

    public Customers(String customerNo, String mobilTel, String workTel, String profession, Date recordDate, List<Cards> cards) {
        this.customerNo = customerNo;
        this.mobilTel = mobilTel;
        this.workTel = workTel;
        this.profession = profession;
        this.recordDate = recordDate;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getWorkTel() {
        return workTel;
    }

    public void setWorkTel(String workTel) {
        this.workTel = workTel;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }

    ;

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", customerNo='" + customerNo + '\'' +
                ", mobilTel='" + mobilTel + '\'' +
                ", workTel='" + workTel + '\'' +
                ", profession='" + profession + '\'' +
                ", recordDate=" + recordDate +
                '}';
    }
}
