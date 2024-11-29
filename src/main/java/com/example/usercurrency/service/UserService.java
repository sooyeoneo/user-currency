package com.example.usercurrency.service;

import com.example.usercurrency.dto.CurrencyReqDto;
import com.example.usercurrency.dto.CurrencyResDto;
import com.example.usercurrency.dto.ExchangeResDto;
import com.example.usercurrency.dto.UserReqDto;
import com.example.usercurrency.dto.UserResDto;
import com.example.usercurrency.entity.Exchange;
import com.example.usercurrency.entity.User;
import com.example.usercurrency.repository.ExchangeRepository;
import com.example.usercurrency.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ExchangeRepository exchangeRepository;

    public UserResDto findById(Long id) {
        return new UserResDto(findUserById(id));
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }

    public List<UserResDto> findAll() {
        return userRepository.findAll().stream().map(UserResDto::toDto).toList();
    }

    @Transactional
    public UserResDto save(UserReqDto userReqDto) {
        User saveUser = userRepository.save(userReqDto.toEntity());
        return new UserResDto(saveUser);
    }

    @Transactional
    public void deleteUserById(Long id) {
        this.findUserById(id);
        userRepository.deleteById(id);
    }

    // 특정 고객의 환전 요청 조회
    public List<ExchangeResDto> findExchangesByUser(Long userId) {
        List<Exchange> exchanges = exchangeRepository.findByUserId(userId);
                return exchanges.stream()
                        .map(ExchangeResDto::new)
                        .toList();
    }
}