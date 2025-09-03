package com.example.payroll.controller;

import com.example.payroll.model.Employee;
import com.example.payroll.service.PayrollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final PayrollService service;
    public EmployeeController(PayrollService service){ this.service = service; }

    @GetMapping
    public List<Employee> all(){ return service.listEmployees(); }

    @PostMapping
    public Employee create(@RequestBody Employee e){ return service.saveEmployee(e); }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id){ return service.getEmployee(id); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
