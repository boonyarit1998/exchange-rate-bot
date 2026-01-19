package com.erb.api.controller;

import com.erb.api.dto.UploadExchangeRateRequest;
import com.erb.api.entity.ExchangeRate;
import com.erb.api.entity.ExchangeRateFile;
import com.erb.api.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exchangeRate")
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @PostMapping("/base64")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ExchangeRate>> uploadExchangeRate(@RequestBody UploadExchangeRateRequest request) throws Exception{
        return ResponseEntity.ok().body(exchangeRateService.uploadExchangeRateBase64(request.getFilename(),request.getBase64Data()));
    }


    @PostMapping("/excel")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ExchangeRate>> uploadExchangeRate(@RequestParam("file")MultipartFile file) throws Exception{
        return ResponseEntity.ok().body(exchangeRateService.uploadExchangeRateExcel(file));
    }

    @GetMapping()
    public ResponseEntity<List<ExchangeRate>> getAllExchangeRate() throws Exception{
        List<ExchangeRate> exchangeRateList = exchangeRateService.getAllExchangeRate();
        return ResponseEntity.ok().body(exchangeRateList);
    }

    @GetMapping("/file")
    public ResponseEntity<List<ExchangeRateFile>> getAllFileExchangeRate() throws Exception{
        List<ExchangeRateFile> exchangeRateList = exchangeRateService.getAllFileExchangeRate();
        return ResponseEntity.ok().body(exchangeRateList);
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<ExchangeRate>> getExchangeRateByDate(@PathVariable String date) throws Exception{
        List<ExchangeRate> exchangeRate = exchangeRateService.getExchangRateByDate(date);
        return  ResponseEntity.ok().body(exchangeRate);
    }

    @DeleteMapping("/{date}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteExchangeRate(@PathVariable String date) throws Exception{
        boolean deleteFlag = exchangeRateService.deleteExchangRate(date);
        if (!deleteFlag){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
