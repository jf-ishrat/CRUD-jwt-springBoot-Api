package com.dsi.firstApiProject.service;

import com.dsi.firstApiProject.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    Optional<Employee> getEmployee(Integer id);

    List<Employee> getEmployees();

    void updateEmployee(Employee employee, Integer id);

    void deleteEmployee(Integer id);


}
