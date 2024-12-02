package com.example.usercurrency.controller;

import com.example.usercurrency.dto.CurrencyReqDto;
import com.example.usercurrency.dto.CurrencyResDto;
import com.example.usercurrency.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping
    public ResponseEntity<CurrencyResDto> createCurrency(@RequestBody @Valid CurrencyReqDto currencyReqDto) { // 유효성 검사 @Valid
        return ResponseEntity.ok().body(currencyService.save(currencyReqDto));
    }

    @GetMapping
    public ResponseEntity<List<CurrencyResDto>> findCurrencies() {
        return ResponseEntity.ok().body(currencyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrencyResDto> findCurrency(@PathVariable Long id) {
        return ResponseEntity.ok().body(currencyService.findById(id));
    }
}
