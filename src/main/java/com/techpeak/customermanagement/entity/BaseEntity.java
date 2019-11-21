package com.techpeak.customermanagement.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Column(name="name", length = 50)
    private String name;
    @Column(name="surname", length = 50)
    private String surname;

    public BaseEntity() {
    }

    public BaseEntity(String name, String surname) {
        this.name = name;
        this.surname = surname;
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
        return "BaseEntity{" +
                "name='" + name + '\'' +
                ", surName='" + surname + '\'' +
                '}';
    }
}
