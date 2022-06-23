package com.dsi.firstApiProject.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

   Employee findByUsername(String username);

}
