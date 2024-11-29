package com.example.usercurrency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "currency_exchange")
@Getter
public class Exchange extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Setter
    @ManyToOne
    @JoinColumn(name = "to_currency_id", nullable = false)
    private Currency currency;

    @Column(nullable = false)
    private int amountInKrw = 0;

    @Column(nullable = false, scale = 2)
    private BigDecimal amountAfterExchange = BigDecimal.valueOf(0.0);

    @Setter
    @Column(nullable = false)
    private String status;

    public Exchange(User user, Currency currency, int amountInKrw, BigDecimal amountAfterExchange, String status) {
        this.user = user;
        this.currency = currency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
    }

    public Exchange() {}
}
