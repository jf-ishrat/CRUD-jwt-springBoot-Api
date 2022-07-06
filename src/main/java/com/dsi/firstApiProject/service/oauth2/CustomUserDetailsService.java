package com.dsi.firstApiProject.service.oauth2;

import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.EmployeeRepository;
import com.dsi.firstApiProject.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override

    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Employee user = employeeRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email : " + email)
                );

        return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );

        return UserPrincipal.create(employee);
    }
}