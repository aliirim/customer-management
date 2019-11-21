package com.techpeak.customermanagement.service;

import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.CustomerDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    public CustomerDto save(CustomerDto customerDto);

    public CustomerDto update(String customerNo, CustomerDto customerDto);

    public CustomerDto getByCustomerNo(String customerNo);

    public CustomerDto getByCustomerName(String name);

    public Boolean deleteByCustomerNo(String customerNo);

    public TPage<CustomerDto> findAllPages(Pageable pageable);

    public List<CustomerDto> getAll();
}
