package com.techpeak.customermanagement.repository;

import com.techpeak.customermanagement.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    public Users findByName(String name);

    public Users findByUsername(String userName);
}
