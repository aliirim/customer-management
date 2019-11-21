package com.techpeak.customermanagement.service.Impl;

import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.CustomerDto;
import com.techpeak.customermanagement.entity.Customers;
import com.techpeak.customermanagement.repository.CustomerRepository;
import com.techpeak.customermanagement.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    ModelMapper modelMapper;
    CustomerRepository customerRepository;

    public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        Customers customers = modelMapper.map(customerDto, Customers.class);
        customers = customerRepository.save(customers);
        return customerDto;
    }

    @Override
    public CustomerDto update(String customerNo, CustomerDto customerDto) {
        Customers customers = customerRepository.findByCustomerNo(customerNo);

        if(customers ==null){
            throw new IllegalArgumentException("Customer Does Not Exist No:" + customerNo);
        }
        customers.setName(customerDto.getName());
        customers.setSurname(customerDto.getSurname());
        return modelMapper.map(customers, CustomerDto.class);
    }

    @Override
    public CustomerDto getByCustomerNo(String customerNo) {
        Customers customers = customerRepository.findByCustomerNo(customerNo);
        return modelMapper.map(customers, CustomerDto.class);
    }

    @Override
    public CustomerDto getByCustomerName(String name) {
        Customers customers = customerRepository.findByName(name);
        return modelMapper.map(customers, CustomerDto.class);
    }

    @Override
    public Boolean deleteByCustomerNo(String customerNo) {
        customerRepository.deleteByCustomerNo(customerNo);
        return Boolean.TRUE;
    }

    @Override
    public TPage<CustomerDto> findAllPages(Pageable pageable) {
        Page<Customers> customers = customerRepository.findAll(pageable);
        TPage<CustomerDto> customerDtoTPage = new TPage<CustomerDto>();
        customerDtoTPage.setPage(customers, Arrays.asList(modelMapper.map(customers.getContent(), CustomerDto[].class)));
        return customerDtoTPage;
    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customers> customers = customerRepository.findAll();
        return Arrays.asList(modelMapper.map(customers, CustomerDto[].class));
    }
}
