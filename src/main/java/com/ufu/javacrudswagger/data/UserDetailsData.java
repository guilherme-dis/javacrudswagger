package com.ufu.javacrudswagger.data;

import com.ufu.javacrudswagger.entities.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class UserDetailsData implements UserDetails {


    private final Optional<Employee> employeeOptional;

    public UserDetailsData(Optional<Employee> employeeOptional) {
        this.employeeOptional = employeeOptional;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return employeeOptional.orElse(new Employee()).getPassword();
    }

    @Override
    public String getUsername() {
        return employeeOptional.orElse(new Employee()).getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
