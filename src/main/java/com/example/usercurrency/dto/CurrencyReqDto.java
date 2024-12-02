package com.example.usercurrency.dto;

import com.example.usercurrency.entity.Currency;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyReqDto {

    @NotNull(message = "환율은 필수입니다.")
    @DecimalMin(value = "0.0", inclusive = false, message = "환율은 0보다 커야 합니다.") // 유효성 검사 JSR 380(Java Bean Validation)
    private BigDecimal currencyRate;

    @NotNull(message = "통화는 필수입니다.")
    @Size(min = 1, max = 50, message = "통화 이름은 1~50자여야 합니다.")
    private String currencyName;

    @NotNull(message = "통화 기호는 필수입니다.")
    @Size(min = 1, max = 10, message = "통화 기호는 1~10자여야 합니다.")
    private String symbol;

    public Currency toEntity() {
        return new Currency(
                this.currencyRate,
                this.currencyName,
                this.symbol
        );
    }
}
