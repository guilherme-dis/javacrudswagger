package com.ufu.javacrudswagger.repositories;

import com.ufu.javacrudswagger.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("select e from Employee e where e.username = ?1")
    Optional<Employee> findByUsername(String username);
}
