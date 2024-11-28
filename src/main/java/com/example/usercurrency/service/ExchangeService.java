package com.example.usercurrency.service;

import com.example.usercurrency.dto.ExchangeReqDto;
import com.example.usercurrency.dto.ExchangeResDto;
import com.example.usercurrency.entity.Currency;
import com.example.usercurrency.entity.Exchange;
import com.example.usercurrency.entity.User;
import com.example.usercurrency.repository.CurrencyRepository;
import com.example.usercurrency.repository.ExchangeRepository;
import com.example.usercurrency.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    // 환전 요청 생성
    public ExchangeResDto createExchange(ExchangeReqDto exchangeReqDto) {
        User user = userRepository.findById(exchangeReqDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        Currency currency = currencyRepository.findById(exchangeReqDto.getCurrencyId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 통화입니다."));
        BigDecimal amountAfterExchange = exchangeReqDto.getAmountInKrw()
                .divide(currency.getExchangeRate(), 2, RoundingMode.HALF_UP);

        Exchange exchange = new Exchange();
        exchange.setUser(user);
        exchange.setCurrency(currency);
        exchange.setAmountInKrw(exchangeReqDto.getAmountInKrw());
        exchange.setAmountAfterExchange(amountAfterExchange);
        exchange.setStatus("normal");

        exchangeRepository.save(exchange);

        return new ExchangeResDto(exchange);
    }
}
