package com.techpeak.customermanagement.api;

import com.techpeak.customermanagement.Util.ApiPaths;
import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.CardDto;
import com.techpeak.customermanagement.dto.CustomerDto;
import com.techpeak.customermanagement.service.Impl.CustomerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.CustomerCtrl.CTRL)
@Api(value = ApiPaths.CustomerCtrl.CTRL)
public class CustomerController {

    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @GetMapping("/{customerNo}")
    @ApiOperation(value = "Get By Customer No Operation", response = CustomerDto.class)
    ResponseEntity<CustomerDto> getByCustomerNo(@PathVariable(value = "customerNo") String customerNo) {
        CustomerDto customerDto = customerServiceImpl.getByCustomerNo(customerNo);
        return ResponseEntity.ok(customerDto);
    }

 /*   @GetMapping("/{name}")
    @ApiOperation(value = "Get By Customer Name Operation", response = CustomerDto.class)
    ResponseEntity<CustomerDto> getByCustomerName(@PathVariable(value = "name") String name){
        CustomerDto customerDto = customerServiceImpl.getByCustomerName(name);
        return ResponseEntity.ok(customerDto);
    }*/

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = CustomerDto.class)
    ResponseEntity<TPage<CustomerDto>> getAllByPagination(Pageable pageable) {
        TPage<CustomerDto> customerDtoTPage = customerServiceImpl.findAllPages(pageable);
        return ResponseEntity.ok(customerDtoTPage);
    }

    @GetMapping
    @ApiOperation(value = "Get All By Operation", response = CustomerDto.class)
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<CustomerDto> customerDtos = customerServiceImpl.getAll();
        return ResponseEntity.ok(customerDtos);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = CustomerDto.class)
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerServiceImpl.save(customerDto));
    }

    @PutMapping("/{customerNo}")
    @ApiOperation(value = "Update Operation", response = CustomerDto.class)
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable String customerNo, @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerServiceImpl.update(customerNo, customerDto));
    }

    @DeleteMapping("/{customerNo}")
    @ApiOperation(value = "Delete Operation", response = CustomerDto.class)
    ResponseEntity<Boolean> deleteById(@PathVariable(value = "customerNo") String customerNo) {
        return ResponseEntity.ok(customerServiceImpl.deleteByCustomerNo(customerNo));
    }
}
