package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Employee;
import com.ufu.javacrudswagger.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee insert(@RequestBody Employee employee) {return employeeRepository.save(employee);}

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeRepository.findById(id).get();
    }


}
