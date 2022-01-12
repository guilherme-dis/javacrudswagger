package com.ufu.javacrudswagger.services;

import com.ufu.javacrudswagger.entities.Employee;
import com.ufu.javacrudswagger.repositories.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder encoder;

    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder encoder) {
        this.employeeRepository = employeeRepository;
        this.encoder = encoder;
    }

    public ResponseEntity<Page<Employee>> findAll(Pageable pageable){
        return ResponseEntity.ok(employeeRepository.findAll(pageable));
    }

    public ResponseEntity<Employee> save(Employee employee){
        employee.setPassword(encoder.encode(employee.getPassword()));//encripting
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    public ResponseEntity<Employee> findById(Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    public ResponseEntity<Employee> deleteById(Long id){
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
    public ResponseEntity<Boolean> validarSenha(String username, String password){
        Optional<Employee> optionalEmployee=employeeRepository.findByUsername(username);
        if(optionalEmployee.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        boolean valid = encoder.matches(password,optionalEmployee.get().getPassword());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
