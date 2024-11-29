package com.example.usercurrency.service;

import com.example.usercurrency.dto.ExchangeReqDto;
import com.example.usercurrency.dto.ExchangeResDto;
import com.example.usercurrency.entity.Currency;
import com.example.usercurrency.entity.Exchange;
import com.example.usercurrency.entity.User;
import com.example.usercurrency.repository.CurrencyRepository;
import com.example.usercurrency.repository.ExchangeRepository;
import com.example.usercurrency.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    // 환전 요청 생성
    public ExchangeResDto createExchange(ExchangeReqDto exchangeReqDto) {

        User user = userRepository.findById(exchangeReqDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        Currency currency = currencyRepository.findById(exchangeReqDto.getCurrencyId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 통화입니다."));

        // currency.getExchangeRate() null 반환 예외 처리
        BigDecimal exchangeRate = currency.getExchangeRate();
        if (exchangeRate == null || exchangeRate.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("유효하지 않은 환율 입니다.");
        }

        // exchangeReqDto.getAmountInKrw() 반환 타입 int -> BigDecimal 변환
        BigDecimal amountInKrw = BigDecimal.valueOf(exchangeReqDto.getAmountInKrw());
        BigDecimal amountAfterExchange = amountInKrw
                .divide(currency.getExchangeRate(), 2, RoundingMode.HALF_UP);

        Exchange exchange = new Exchange(user, currency, exchangeReqDto.getAmountInKrw(), amountAfterExchange, "normal");
        exchangeRepository.save(exchange);

        return new ExchangeResDto(exchange);
    }

    // 특정 고객의 환전 요청 조회
    public List<ExchangeResDto> findExchangesByUser(Long userId) {
        return exchangeRepository.findByUserId(userId)
                .stream()
                .map(ExchangeResDto::new)
                .toList();
    }

    // 환전 요청 상태 변경
    public ExchangeResDto updateExchangeStatus(Long id, String status) {
        Exchange exchange = exchangeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 환전 요청입니다."));

        if (!"normal".equals(status) && !"cancelled".equals(status)) {
            throw new IllegalArgumentException("잘못된 상태 값입니다.");
        }

        exchange.setStatus(status);
        exchangeRepository.save(exchange);

        return new ExchangeResDto(exchange);
    }

    // 특정 환전 요청 삭제
    public void deleteExchangeById(Long id) {
        if (!exchangeRepository.existsById(id)) {
            throw new IllegalArgumentException("존재하지 않는 환전 요청입니다.");
        }
        exchangeRepository.deleteById(id);
    }
}
