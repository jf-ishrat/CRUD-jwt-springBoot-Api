package com.dsi.firstApiProject.service;


import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.EmployeeRepository;
import com.dsi.firstApiProject.domain.Permission;
import com.dsi.firstApiProject.domain.PermissionRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
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
import java.util.*;

@Service @RequiredArgsConstructor
@Transactional @Slf4j
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;

        @Override
    public Employee saveEmployee(Employee employee) {

            if(employee.getUsername() == null && employee.getPassword()==null){
                employee.setUsername(employee.getEmail());
                employee.setPassword(passwordEncoder.encode(employee.getEmail()));

            }
            else{
                employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            }
        return employeeRepository.save(employee);
    }

    @Override
    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public void addPermissionToEmployee(String username, String permissionName) {
        Employee employee = employeeRepository.findByUsername(username);
        Permission permission = permissionRepository.findByname(permissionName);
        employee.getPermissions().add(permission);

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

        Map<String,String> payload = new HashMap<String,String>();

        payload.put("username", employee.getUsername());
        payload.put("employee_id",employee.getEmployeeId().toString());
        payload.put("role", employee.getRole());

         String jsonPayload = new Gson().toJson(payload);
         log.info("stringPayload {}",jsonPayload);

        authorities.add(new SimpleGrantedAuthority(employee.getRole()));

        return new User(jsonPayload, employee.getPassword(), authorities);
    }


}
