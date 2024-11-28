package com.example.usercurrency.entity;

import com.example.usercurrency.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "currency")
@Getter
public class Currency extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal exchangeRate;
    private String currencyName;
    private String symbol;



    public Currency(BigDecimal exchangeRate, String currencyName, String symbol) {
        this.exchangeRate = exchangeRate;
        this.currencyName = currencyName;
        this.symbol = symbol;
    }

    public Currency() {}
}
