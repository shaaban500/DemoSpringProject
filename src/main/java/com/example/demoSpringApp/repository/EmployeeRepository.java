package com.example.demoSpringApp.repository;

import com.example.demoSpringApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
