package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Address;
import com.ufu.javacrudswagger.entities.Employee;
import com.ufu.javacrudswagger.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;



    @PostMapping
    public Employee insert(@RequestBody Employee employee) {return employeeRepository.save(employee);}

    @GetMapping
    public ResponseEntity<Page<Employee>> findAll(Pageable pageable){
        Page<Employee>result= employeeRepository.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> Delete(@PathVariable Long id)
    {
        try {
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            Optional<Employee> employee=employeeRepository.findById(id);
            if (employee.isPresent()){
                return new ResponseEntity<>(HttpStatus.valueOf(420));
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }

}
