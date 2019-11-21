package com.techpeak.customermanagement.repository;

import com.techpeak.customermanagement.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {

    public Customers findByCustomerNo(String customerNo);

    public Customers findByName(String name);

    public void deleteByCustomerNo(String name);
}
