package com.npg.payroll.repository;

import com.npg.payroll.entity.ExchangeRate;
import com.npg.payroll.entity.ExchangeRateFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateFileRepository extends JpaRepository<ExchangeRateFile,Long> {
    ExchangeRateFile exchangeRateFileDate(String date);
}
