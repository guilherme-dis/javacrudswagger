package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Employee;
import com.ufu.javacrudswagger.services.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "saving a employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to save this"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public Employee insert(@RequestBody @Valid Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping
    @ApiOperation(value = "return a employee list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to find all employee"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public ResponseEntity<Page<Employee>> findAll(Pageable pageable) {
        return ResponseEntity.ok(employeeService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "selecting an employee by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to find this"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return employeeService.findById(id);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "deleting successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to delete this"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 420, message = "the data you tried to delete has other data related to it as a foreign key")})
    public ResponseEntity<Employee> Delete(@PathVariable Long id) {
        return employeeService.deleteById(id);
    }


}
