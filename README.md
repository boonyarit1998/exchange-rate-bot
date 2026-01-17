# exchange-rate-bot

## 📡 API Endpoints (ตัวอย่าง)
```
# Exchange Rates
POST    /api/v1/exchange_rate/upload
GET     /api/v1/exchange_rate
GET     /api/v1/exchange_rate/file
GET     /api/v1/exchange_rate/{date}
DELETE  /api/v1/exchange_rate/{date}

```

## 💻 ตัวอย่าง Code Structure
```
src/main/java/com/erb/api/
├── config/
│   ├── SecurityConfig.java
│   ├── SchedulerConfig.java
│   └── RedisConfig.java
├── controller/
│   └── ExchangeRateController.java
├── service/
│   └── ExchangeRateService.java
├── repository/
│   ├── ExchangeRateFileRepository.java
│   └── ExchangeRateRepository.java
├── entity/
│   ├── ExchangeRate.java
│   └── ExchangeRateFile.java
├── dto/
│   └── UploadExchangeRateRequest.java
├── scheduler/
│   └── ExchangeScheduler.java
└── exception/
    ├── UploadFileException.java
    └── UploadFileDuplicateException.java