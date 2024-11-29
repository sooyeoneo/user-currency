package com.example.usercurrency.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class UserExchangeDto {

    private Long userId;
    private Long requestCount; // 환전 요청 총 row 수
    private BigDecimal totalAmountInKrw; // 총 환전 금액

    public UserExchangeDto(Long userId, Long requestCount, Number totalAmountInKrw) {
        this.userId = userId;
        this.requestCount = requestCount;
        this.totalAmountInKrw = totalAmountInKrw instanceof BigDecimal
                ? ((BigDecimal) totalAmountInKrw).setScale(2, RoundingMode.HALF_EVEN)
                : BigDecimal.valueOf(totalAmountInKrw.doubleValue()).setScale(2, RoundingMode.HALF_EVEN);
    }
}
