package com.dsi.firstApiProject.service;

import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.Permission;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Permission savePermission(Permission permission);
    void addPermissionToEmployee(String username, Collection permissionName);
    Optional<Employee> getEmployee(Integer id);

    Page<Employee> getEmployees(Optional<Integer> page);

    List<Permission> getPermissions();

    void updateEmployee(Employee employee, Integer id);

    void deleteEmployee(Integer id);


}
