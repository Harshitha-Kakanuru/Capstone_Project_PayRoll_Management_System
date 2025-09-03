package com.example.payroll.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.YearMonth;

@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Employee employee;

    @Min(1) @Max(12)
    private int month;

    private int year;

    @PositiveOrZero
    private double basic;

    @PositiveOrZero
    private double allowances;

    @PositiveOrZero
    private double deductions;

    private double netPay;

    @PrePersist @PreUpdate
    private void computeNet() {
        this.netPay = basic + allowances - deductions;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public double getBasic() { return basic; }
    public void setBasic(double basic) { this.basic = basic; }
    public double getAllowances() { return allowances; }
    public void setAllowances(double allowances) { this.allowances = allowances; }
    public double getDeductions() { return deductions; }
    public void setDeductions(double deductions) { this.deductions = deductions; }
    public double getNetPay() { return netPay; }
    public void setNetPay(double netPay) { this.netPay = netPay; }
}
