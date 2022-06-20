package com.dsi.firstApiProject.service;


import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.EmployeeRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
@Transactional @Slf4j
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

        @Override
    public Employee saveEmployee(Employee employee) {

            if(employee.getUsername() == null && employee.getPassword()==null){
                employee.setUsername(employee.getEmail());
                employee.setPassword(passwordEncoder.encode(employee.getLastName()));

            }
            else{
                employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            }
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployee(Integer id) {
        return employeeRepository.findById(id);
    }


    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee, Integer id) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);
        if(employee == null){
            log.error("Employee not found");
        }else{
            log.info("user found in the database: {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        String usernameIDrole = String.join("-", employee.getUsername(),employee.getEmployeeId().toString(), employee.getRole());

        authorities.add(new SimpleGrantedAuthority(employee.getRole()));
       // authorities.add(new SimpleGrantedAuthority(employee.getEmployeeId().toString()));

        return new User(usernameIDrole, employee.getPassword(), authorities);
    }


}
