package com.example.usercurrency.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeReqDto {

    private Long userId;
    private Long currencyId;
    private int amountInKrw;
}
