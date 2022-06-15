package com.dsi.firstApiProject.controllers;

import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/employees")
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);

        return employees;
    }
    @RequestMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable Integer id){

        return employeeRepository.findById(id);

    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable Integer id) {
        employeeRepository.save(employee);
    }
    @DeleteMapping("/employees/{id}")
    public void updateEmployee(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
    }


 /*   @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
*/

}
