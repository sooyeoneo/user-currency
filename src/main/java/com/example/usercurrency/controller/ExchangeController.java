package com.example.usercurrency.controller;

import com.example.usercurrency.dto.ExchangeReqDto;
import com.example.usercurrency.dto.ExchangeResDto;
import com.example.usercurrency.service.ExchangeService;
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
@RequestMapping("/exchanges")
public class ExchangeController {

    private final ExchangeService exchangeService;

    // 환전 요청 생성
    @PostMapping
    public ResponseEntity<ExchangeResDto> createExchange(@RequestBody ExchangeReqDto exchangeReqDto) {
        return ResponseEntity.ok().body(exchangeService.createExchange(exchangeReqDto));
    }

    // 특정 고객의 환전 요청 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExchangeResDto>> findExchangeByUser(@PathVariable Long userId) {
        return ResponseEntity.ok().body(exchangeService.findExchangesByUser(userId));
    }
}