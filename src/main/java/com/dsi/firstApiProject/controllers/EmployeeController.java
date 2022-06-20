package com.dsi.firstApiProject.controllers;
import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.service.EmployeeService;
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

    @PutMapping("/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable Integer id) {
        employeeService.updateEmployee(employee,id);
    }
    @DeleteMapping("/employees/{id}")
    public void DeleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }

}
