package com.dsi.firstApiProject.controllers;

import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

//@Service
public class EmployeeService {

 /*   @Autowired
    private EmployeeRepository employeeRepository;
    public <T> List<T>
    getCollectionFromIterable(Iterable<T> itr)
    {
        // Create an empty Collection to hold the result
        List<T> cltn = new ArrayList<T>();

        // Iterate through the iterable to
        // add each element into the collection
        for (T t : itr)
            cltn.add(t);

        // Return the converted collection
        return cltn;
    }

    // private List<Employee> employees = new ArrayList<Employee>(employeeRepository.findAll());

   private List<Employee> employees = getCollectionFromIterable(employeeRepository.findAll());

    public List<Employee> getAllEmployees(){
          return employees;
    }
*/

/*
  spring.datasource.url= jdbc:postgresql://localhost:5432/employees
spring.datasource.username= postgres
spring.datasource.password= epiphany
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect
# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update
e*/

}
