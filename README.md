# npg-ws-payroll

## 📡 API Endpoints (ตัวอย่าง)
```
# Employees
POST   /api/v1/employees
GET    /api/v1/employees
GET    /api/v1/employees/{id}
PUT    /api/v1/employees/{id}
DELETE /api/v1/employees/{id}

# Exchange Rates
GET    /api/v1/exchange-rates/latest
GET    /api/v1/exchange-rates/history
POST   /api/v1/exchange-rates/refresh

# Payroll
POST   /api/v1/payrolls/calculate
POST   /api/v1/payrolls/process
GET    /api/v1/payrolls
GET    /api/v1/payrolls/{id}
GET    /api/v1/payrolls/{id}/items
GET    /api/v1/payrolls/{id}/payslip/{employeeId}

# Reports
GET    /api/v1/reports/monthly-summary
GET    /api/v1/reports/currency-exposure
GET    /api/v1/reports/export
```

## 💻 ตัวอย่าง Code Structure
```
src/main/java/com/company/payroll/
├── config/
│   ├── SecurityConfig.java
│   ├── SchedulerConfig.java
│   └── RedisConfig.java
├── controller/
│   ├── EmployeeController.java
│   ├── PayrollController.java
│   └── ExchangeRateController.java
├── service/
│   ├── EmployeeService.java
│   ├── PayrollService.java
│   ├── ExchangeRateService.java
│   ├── PayslipService.java
│   └── NotificationService.java
├── repository/
│   ├── EmployeeRepository.java
│   ├── PayrollRepository.java
│   └── ExchangeRateRepository.java
├── model/
│   ├── Employee.java
│   ├── Payroll.java
│   ├── PayrollItem.java
│   └── ExchangeRate.java
├── dto/
│   ├── EmployeeDTO.java
│   ├── PayrollRequest.java
│   └── PayrollResponse.java
├── scheduler/
│   └── PayrollScheduler.java
├── client/
│   └── ExchangeRateClient.java
└── exception/
    └── GlobalExceptionHandler.java