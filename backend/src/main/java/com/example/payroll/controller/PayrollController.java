package com.example.payroll.controller;

import com.example.payroll.model.Payroll;
import com.example.payroll.service.PayrollService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {
    private final PayrollService service;
    public PayrollController(PayrollService service){ this.service = service; }

    @GetMapping
    public List<Payroll> all(){ return service.listPayrolls(); }

    @GetMapping("/employee/{id}")
    public List<Payroll> forEmployee(@PathVariable Long id){ return service.payrollsForEmployee(id); }

    @PostMapping("/generate")
    public Payroll generate(@RequestBody Map<String, Object> body){
        Long employeeId = ((Number)body.get("employeeId")).longValue();
        int month = ((Number)body.get("month")).intValue();
        int year = ((Number)body.get("year")).intValue();
        double basic = ((Number)body.get("basic")).doubleValue();
        double allowances = ((Number)body.get("allowances")).doubleValue();
        double deductions = ((Number)body.get("deductions")).doubleValue();
        return service.generatePayroll(employeeId, month, year, basic, allowances, deductions);
    }
}
