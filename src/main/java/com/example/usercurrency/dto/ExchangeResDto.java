package com.example.usercurrency.dto;

import com.example.usercurrency.entity.Exchange;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeResDto {

    private Long id;
    private Long userId;
    private Long currencyId;
    private int amountInKrw;
    private BigDecimal amountAfterExchange;
    private String status;

    public ExchangeResDto(Exchange exchange) {
        this.id = exchange.getId();
        this.userId = exchange.getUser().getId();
        this.currencyId = exchange.getCurrency().getId();
        this.amountInKrw = exchange.getAmountInKrw();
        this.amountAfterExchange = exchange.getAmountAfterExchange();
        this.status = exchange.getStatus();
    }
}
