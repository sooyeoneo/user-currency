package com.example.usercurrency.dto;

import com.example.usercurrency.entity.Currency;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyReqDto {

    @NotNull(message = "환율은 필수입니다.")
    private BigDecimal currencyRate;

    @NotNull(message = "통화는 필수입니다.")
    private String currencyName;

    @NotNull(message = "통화 기호는 필수입니다.")
    private String symbol;

    public Currency toEntity() {
        return new Currency(
                this.currencyRate,
                this.currencyName,
                this.symbol
        );
    }
}
