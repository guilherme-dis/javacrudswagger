package com.ufu.javacrudswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//exclude = {SecurityAutoConfiguration.class}
@SpringBootApplication()
public class JavacrudswaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavacrudswaggerApplication.class, args);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
