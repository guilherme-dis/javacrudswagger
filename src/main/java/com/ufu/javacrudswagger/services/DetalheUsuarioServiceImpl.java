package com.ufu.javacrudswagger.services;

import com.ufu.javacrudswagger.data.DetalheUsuarioData;
import com.ufu.javacrudswagger.entities.Employee;
import com.ufu.javacrudswagger.repositories.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public DetalheUsuarioServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        if (employee.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }

        return new DetalheUsuarioData(employee);
    }

}