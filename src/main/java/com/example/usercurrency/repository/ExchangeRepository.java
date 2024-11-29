package com.example.usercurrency.repository;

import com.example.usercurrency.dto.UserExchangeDto;
import com.example.usercurrency.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    // 특정 고객 환전 요청 조회
    List<Exchange> findByUserId(Long userId);

    // 고객별 환전 요청 그룹화 결과 조회 (JPQL)
    @Query("SELECT new com.example.dto.UserExchageDto(e.user.id, COUNT(e)," +
            "FROM Exchange e" +
            "GROUP BY e.user.id")
    List<UserExchangeDto> findGroupedExchangeSummary();
}
