package com.example.demoSpringApp.controller;
import com.example.demoSpringApp.model.Employee;
import com.example.demoSpringApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeID){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeID),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeID, @RequestBody Employee employee) {
        return new  ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeID), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeID) {
        employeeService.deleteEmployee(employeeID);
        return new ResponseEntity<String>("Employee deleted Successfully.", HttpStatus.OK);
    }
}
