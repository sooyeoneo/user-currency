package com.example.usercurrency.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeReqDto {

    private Long userId;
    private Long currencyId;

    @NotNull(message = "환전 금액은 필수입니다.")
    @Min(value = 1, message = "환전 금액은 1 이상이어야 합니다.")
    private int amountInKrw;

    @NotBlank(message = "환전 상태는 필수입니다.")
    private String status;
}
