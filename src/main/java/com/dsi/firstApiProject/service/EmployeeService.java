package com.dsi.firstApiProject.service;

import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.Permission;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Permission savePermission(Permission permission);
    void addPermissionToEmployee(String username, String permissionName);
    Optional<Employee> getEmployee(Integer id);

    List<Employee> getEmployees();

    void updateEmployee(Employee employee, Integer id);

    void deleteEmployee(Integer id);


}
