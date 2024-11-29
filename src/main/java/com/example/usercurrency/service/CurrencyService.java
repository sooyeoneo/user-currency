package com.example.usercurrency.service;

import com.example.usercurrency.dto.CurrencyReqDto;
import com.example.usercurrency.dto.CurrencyResDto;
import com.example.usercurrency.entity.Currency;
import com.example.usercurrency.repository.CurrencyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyResDto findById(Long id) {
        return new CurrencyResDto(findCurrencyById(id));
    }

    public Currency findCurrencyById(Long id) {
        return currencyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 통화 입니다."));
    }

    public List<CurrencyResDto> findAll() {
        return currencyRepository.findAll().stream().map(CurrencyResDto::toDto).toList();
    }

    @Transactional
    public CurrencyResDto save(CurrencyReqDto currencyReqDto) {
        Currency saveCurrency = currencyRepository.save(currencyReqDto.toEntity());
        return new CurrencyResDto(saveCurrency);
    }
}
