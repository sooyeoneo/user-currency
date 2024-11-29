package com.example.usercurrency.dto;

import com.example.usercurrency.entity.Currency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyReqDto {

    private BigDecimal currencyRate;
    private String currencyName;
    private String symbol;

    public Currency toEntity() {
        return new Currency(
                this.currencyRate,
                this.currencyName,
                this.symbol
        );
    }
}
