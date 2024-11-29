package com.example.usercurrency.dto;

import com.example.usercurrency.entity.Currency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyResDto {

    private Long id;

    private BigDecimal exchangeRate;
    private String currencyName;
    private String symbol;

    public CurrencyResDto(Currency currency) {

        this.id = currency.getId();
        this.exchangeRate = currency.getExchangeRate();
        this.currencyName = currency.getCurrencyName();
        this.symbol = currency.getSymbol();
    }

    public CurrencyResDto(Long id, BigDecimal exchangeRate, String currencyName, String symbol) {
        this.id = id;
        this.exchangeRate = exchangeRate;
        this.currencyName = currencyName;
        this.symbol = symbol;
    }

    public static CurrencyResDto toDto(Currency currency) {
        return new CurrencyResDto(
                currency.getId(),
                currency.getExchangeRate(),
                currency.getCurrencyName(),
                currency.getSymbol()
        );
    }
}
