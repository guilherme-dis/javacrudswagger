package com.ufu.javacrudswagger.repositories;

import com.ufu.javacrudswagger.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
