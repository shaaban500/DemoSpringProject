package com.example.demoSpringApp.service.Impl;
import com.example.demoSpringApp.model.Employee;
import com.example.demoSpringApp.repository.EmployeeRepository;
import com.example.demoSpringApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        var existingEmployee = employeeRepository.findById(id).orElseThrow(RuntimeException::new);

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(RuntimeException::new);
        employeeRepository.deleteById(id);
    }
}
