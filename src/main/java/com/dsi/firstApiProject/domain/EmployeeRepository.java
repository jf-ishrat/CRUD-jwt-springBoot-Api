package com.dsi.firstApiProject.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

   Employee findByUsername(String username);
   Optional<Employee> findByEmail(String email);

   Boolean existsByEmail(String email);

}
