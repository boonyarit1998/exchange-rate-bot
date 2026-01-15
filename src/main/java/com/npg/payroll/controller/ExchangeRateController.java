package com.npg.payroll.controller;

import com.npg.payroll.entity.ExchangeRate;
import com.npg.payroll.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exchange-rates")
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @PostMapping()
    public List<ExchangeRate> uploadExchangeRate(String filename,String base64Data) throws Exception{
        List<ExchangeRate> newExchangRate = exchangeRateService.upload(filename,base64Data);
        return newExchangRate;
    }

    @GetMapping()
    public List<ExchangeRate> getAllExchangeRate() throws Exception{
        List<ExchangeRate> exchangeRateList = exchangeRateService.getAllExchangeRate();
        return exchangeRateList;
    }

    @GetMapping("/{date}")
    public ExchangeRate getExchangeRateByDate(@PathVariable String date) throws Exception{
        ExchangeRate exchangeRate = exchangeRateService.getExchangRateByDate(date);
        return  exchangeRate;
    }

    @DeleteMapping("/{date}")
    public void deleteExchangeRate(@PathVariable String date) throws Exception{
        exchangeRateService.deleteExchangRate(date);
    }

}
