package com.example.payroll.service;

import com.example.payroll.model.Employee;
import com.example.payroll.model.Payroll;
import com.example.payroll.repository.EmployeeRepository;
import com.example.payroll.repository.PayrollRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PayrollService {
    private final EmployeeRepository employeeRepo;
    private final PayrollRepository payrollRepo;

    public PayrollService(EmployeeRepository employeeRepo, PayrollRepository payrollRepo) {
        this.employeeRepo = employeeRepo;
        this.payrollRepo = payrollRepo;
    }

    public List<Employee> listEmployees() { return employeeRepo.findAll(); }
    public Employee saveEmployee(Employee e) { return employeeRepo.save(e); }
    public void deleteEmployee(Long id) { employeeRepo.deleteById(id); }
    public Employee getEmployee(Long id) { return employeeRepo.findById(id).orElseThrow(); }

    @Transactional
    public Payroll generatePayroll(Long employeeId, int month, int year, double basic, double allowances, double deductions) {
        Employee emp = employeeRepo.findById(employeeId).orElseThrow();
        if (payrollRepo.existsByEmployeeAndMonthAndYear(emp, month, year)) {
            throw new IllegalArgumentException("Payroll already exists for this month/year");
        }
        Payroll p = new Payroll();
        p.setEmployee(emp);
        p.setMonth(month);
        p.setYear(year);
        p.setBasic(basic);
        p.setAllowances(allowances);
        p.setDeductions(deductions);
        return payrollRepo.save(p);
    }

    public List<Payroll> listPayrolls() { return payrollRepo.findAll(); }
    public List<Payroll> payrollsForEmployee(Long employeeId) {
        Employee emp = employeeRepo.findById(employeeId).orElseThrow();
        return payrollRepo.findByEmployee(emp);
    }
}
