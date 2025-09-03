# Payroll Backend (Spring Boot, Java 22)

## Requirements
- Java 22 (JDK 22)
- Maven 3.9+
- MySQL 8.x (user: `root`, password: `Harshitha@3130`)

## Run
```bash
mvn spring-boot:run
```

## API
- `GET /api/employees`
- `POST /api/employees`
- `GET /api/employees/{id}`
- `DELETE /api/employees/{id}`
- `GET /api/payrolls`
- `GET /api/payrolls/employee/{id}`
- `POST /api/payrolls/generate`
```json
{
  "employeeId": 1,
  "month": 9,
  "year": 2025,
  "basic": 50000,
  "allowances": 5000,
  "deductions": 2000
}
```
