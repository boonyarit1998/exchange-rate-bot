package com.npg.payroll.repository;

import com.npg.payroll.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {

    ExchangeRate findByDate(String date);
}
