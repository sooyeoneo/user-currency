package com.example.usercurrency.repository;

import com.example.usercurrency.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    // 특정 고객 환전 요청 조회
    List<Exchange> findByUserId(Long userId);
}
