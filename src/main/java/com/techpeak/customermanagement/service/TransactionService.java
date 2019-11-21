package com.techpeak.customermanagement.service;

import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.TransactionDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionService {

    public TransactionDto save(TransactionDto transactionDto);

    public TransactionDto update(int id, TransactionDto transactionDto);

    public TransactionDto getById(int id);

    public TransactionDto getByCardNo(String cardNo);

    public Boolean deleteById(int id);

    public TPage<TransactionDto> findAllPages(Pageable pageable);

    public List<TransactionDto> getAll();
}
