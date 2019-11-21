package com.techpeak.customermanagement.repository;

import com.techpeak.customermanagement.entity.Cards;
import com.techpeak.customermanagement.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Cards,Integer> {

    public Cards findByCardNo(String cardNo);

    public void deleteByCardNo(String name);
}
