package com.example.usercurrency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class UserExchangeDto {

    private Long userId;
    private Long requestCount; // 환전 요청 총 row 수
    private BigDecimal totalAmountInKrw; // 총 환전 금액
}
