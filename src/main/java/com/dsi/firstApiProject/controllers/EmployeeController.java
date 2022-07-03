package com.dsi.firstApiProject.controllers;
import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.Permission;
import com.dsi.firstApiProject.service.EmployeeService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @RequestMapping("/employees")
    public ResponseEntity<Page<Employee>> getEmployees(
            @RequestParam Optional<Integer> page
    ) {
        return ResponseEntity.ok().body(employeeService.getEmployees(page));
    }

    @RequestMapping("/permissions")
    public ResponseEntity<List<Permission>> getPermissions() {
        return ResponseEntity.ok().body(employeeService.getPermissions());
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
        log.info("item {}", item);
        employeeService.addPermissionToEmployee(item.getUsername(),item.getPermissionNames());
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
   // private String permissionName;
    private Collection<String> permissionNames = new ArrayList<String>();

}


