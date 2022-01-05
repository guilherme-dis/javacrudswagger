package com.ufu.javacrudswagger.repositories;

import com.ufu.javacrudswagger.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

}