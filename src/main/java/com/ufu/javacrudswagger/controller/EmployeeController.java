package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Employee;
import com.ufu.javacrudswagger.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee insert(@RequestBody @Valid Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> findAll(Pageable pageable) {
        return ResponseEntity.ok(employeeService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return employeeService.findById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> Delete(@PathVariable Long id) {
        return employeeService.deleteById(id);
    }


}
