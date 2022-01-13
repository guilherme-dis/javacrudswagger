package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validarsenha")
@Api(value = "API REST Address")
@CrossOrigin(origins = "*")
public class ValidatingPasswordController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ApiOperation(value = "password validatingg")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String username, @RequestParam String password) {
        return employeeService.validarSenha(username, password);
    }
}
