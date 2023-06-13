package com.robson.robson.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}
