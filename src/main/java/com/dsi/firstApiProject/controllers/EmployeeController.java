package com.dsi.firstApiProject.controllers;
import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.Permission;
import com.dsi.firstApiProject.service.EmployeeService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

@RequestMapping("/employees")
public ResponseEntity<List<Employee>> getEmployees() {
    return ResponseEntity.ok().body(employeeService.getEmployees());
}
    @RequestMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable Integer id){

        return employeeService.getEmployee(id);

    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.saveEmployee(employee));
    }
    @PostMapping("/permissions/save")
    public ResponseEntity<Permission> savePermission(@RequestBody Permission permission) {
        return ResponseEntity.ok().body(employeeService.savePermission(permission));
    }

    @PostMapping("/permissions/addtoemployee")
    public ResponseEntity<?> addPermissionToUser(@RequestBody PermissionToEmployee item) {
        employeeService.addPermissionToEmployee(item.getUsername(),item.getPermissionName());
        return ResponseEntity.ok().build();
    }


    @PutMapping("/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable Integer id) {
        employeeService.updateEmployee(employee,id);
    }
    @DeleteMapping("/employees/{id}")
    public void DeleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }


}
@Data
class PermissionToEmployee {
    private String username;
    private String permissionName;

}

