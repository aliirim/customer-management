package com.techpeak.customermanagement.service.Impl;

import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.CardDto;
import com.techpeak.customermanagement.dto.TransactionDto;
import com.techpeak.customermanagement.entity.Cards;
import com.techpeak.customermanagement.entity.Transactions;
import com.techpeak.customermanagement.repository.CardRepository;
import com.techpeak.customermanagement.repository.TransactionRepository;
import com.techpeak.customermanagement.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    ModelMapper modelMapper;
    TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(ModelMapper modelMapper, TransactionRepository transactionRepository) {
        this.modelMapper = modelMapper;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDto save(TransactionDto transactionDto) {
        Transactions transactions = modelMapper.map(transactionDto, Transactions.class);
        transactions = transactionRepository.save(transactions);
        transactionDto.setId(transactions.getId());
        return transactionDto;
    }

    @Override
    public TransactionDto update(int id, TransactionDto transactionDto) {
        Transactions transactions = transactionRepository.getOne(id);

        if (transactions == null) {
            throw new IllegalArgumentException("Transaction Does Not Exist No:" + id);
        }
        transactions.setTransactionType(transactionDto.getTransactionType());
        transactions.setFee(transactionDto.getFee());
        return modelMapper.map(transactions, TransactionDto.class);
    }

    @Override
    public TransactionDto getById(int id) {
        Transactions transactions = transactionRepository.getOne(id);
        return modelMapper.map(transactions, TransactionDto.class);
    }

    @Override
    public TransactionDto getByCardNo(String cardNo) {
        Transactions transactions = transactionRepository.findByCards(cardNo);
        return modelMapper.map(transactions, TransactionDto.class);
    }

    @Override
    public Boolean deleteById(int id) {
        transactionRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public TPage<TransactionDto> findAllPages(Pageable pageable) {
        Page<Transactions> transactions = transactionRepository.findAll(pageable);
        TPage<TransactionDto> transactionDtoTPage = new TPage<TransactionDto>();
        transactionDtoTPage.setPage(transactions, Arrays.asList(modelMapper.map(transactions.getContent(), TransactionDto[].class)));
        return transactionDtoTPage;
    }

    @Override
    public List<TransactionDto> getAll() {
        List<Transactions> transactions = transactionRepository.findAll();
        return Arrays.asList(modelMapper.map(transactions, TransactionDto[].class));
    }
}
