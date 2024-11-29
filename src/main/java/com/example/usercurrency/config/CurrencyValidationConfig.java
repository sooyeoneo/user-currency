package com.example.usercurrency.config;

import com.example.usercurrency.entity.Currency;
import com.example.usercurrency.repository.CurrencyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CurrencyValidationConfig {

   private final CurrencyRepository currencyRepository;

   // Spring 컨텍스트가 초기화 되고 애플리케이션이 시작될 때 한 번 실행
   @PostConstruct
   public void validateCurrencyData() {
       log.info("통화 데이터 유효성 검사를 시작합니다.");

       List<Currency> invalidCurrencies = currencyRepository.findAll().stream()
               .filter(currency -> currency.getExchangeRate() == null // 환율 값이 null인 경우
                       || currency.getExchangeRate().compareTo(BigDecimal.ZERO) <= 0 // 환율 값이 0 또는 음수인 경우
                       || currency.getExchangeRate().compareTo(new BigDecimal("1000")) > 0) // 환율 값이 설정한 범위를 초과하는 경우
               .toList();

       if (invalidCurrencies.isEmpty()) {
           log.info("모든 통화 데이터가 유효합니다."); // 유효하지 않은 경우 log.info로 확인 메시지 출력
       } else {
           log.warn("유효하지 않은 통화 데이터가 발견되었습니다.");
           invalidCurrencies.forEach(currency -> log.warn( // 유효하지 않은 데이터의 상세 정보를 log.warn으로 기록
                   "ID : {}, Name : {}, Rate : {}",
                   currency.getId(), currency.getCurrencyName(), currency.getExchangeRate()
           ));
       }
   }
}
