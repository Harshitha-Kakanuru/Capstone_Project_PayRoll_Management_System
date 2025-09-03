package com.example.payroll.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.payroll.model.Payroll;
import com.example.payroll.model.Employee;
import java.util.List;
public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    List<Payroll> findByEmployee(Employee employee);
    boolean existsByEmployeeAndMonthAndYear(Employee employee, int month, int year);
}
