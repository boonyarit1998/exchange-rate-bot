package com.npg.payroll.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="tb_exchange_rate")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long exchangeRateFileId;

    private String currencyCode;

    @Column(precision = 10,scale = 4)
    private BigDecimal buyingSightBill;

    @Column(precision = 10,scale = 4)
    private BigDecimal buyingTt;

    @Column(precision = 10,scale = 4)
    private BigDecimal sellingBillDdTt;

    private String recordStatus;


}
