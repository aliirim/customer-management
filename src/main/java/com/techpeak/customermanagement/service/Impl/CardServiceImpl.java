package com.techpeak.customermanagement.service.Impl;

import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.CardDto;
import com.techpeak.customermanagement.dto.CustomerDto;
import com.techpeak.customermanagement.entity.Cards;
import com.techpeak.customermanagement.entity.Customers;
import com.techpeak.customermanagement.repository.CardRepository;
import com.techpeak.customermanagement.service.CardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    ModelMapper modelMapper;
    CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(ModelMapper modelMapper, CardRepository cardRepository) {
        this.modelMapper = modelMapper;
        this.cardRepository = cardRepository;
    }

    @Override
    public CardDto save(CardDto cardDto) {
        Cards cards = modelMapper.map(cardDto, Cards.class);
        cards = cardRepository.save(cards);
        return cardDto;
    }

    @Override
    public CardDto update(String cardNo, CardDto cardDto) {
        Cards cards = cardRepository.findByCardNo(cardNo);

        if(cards ==null){
            throw new IllegalArgumentException("Card Does Not Exist No:" + cardNo);
        }
        cards.setCardType(cardDto.getCardType());
        cards.setCardStatus(cardDto.getCardStatus());
        return modelMapper.map(cards, CardDto.class);
    }

    @Override
    public CardDto getByCardNo(String cardNo) {
        Cards cards = cardRepository.findByCardNo(cardNo);
        return modelMapper.map(cards, CardDto.class);
    }

    @Override
    public Boolean deleteByCardNo(String cardNo) {
        cardRepository.deleteByCardNo(cardNo);
        return Boolean.TRUE;
    }

    @Override
    public TPage<CardDto> findAllPages(Pageable pageable) {
        Page<Cards> Cards = cardRepository.findAll(pageable);
        TPage<CardDto> cardDtoTPage = new TPage<CardDto>();
        cardDtoTPage.setPage(Cards, Arrays.asList(modelMapper.map(Cards.getContent(), CardDto[].class)));
        return cardDtoTPage;
    }

    @Override
    public List<CardDto> getAll() {
        List<Cards> cards = cardRepository.findAll();
        return Arrays.asList(modelMapper.map(cards, CardDto[].class));
    }
}
