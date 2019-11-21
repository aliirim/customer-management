package com.techpeak.customermanagement.service;

import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.CardDto;
import com.techpeak.customermanagement.dto.CustomerDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CardService {

    public CardDto save(CardDto cardDto);

    public CardDto update(String cardNo, CardDto cardDto);

    public CardDto getByCardNo(String cardNo);

    public Boolean deleteByCardNo(String cardNo);

    public TPage<CardDto> findAllPages(Pageable pageable);

    public List<CardDto> getAll();
}
