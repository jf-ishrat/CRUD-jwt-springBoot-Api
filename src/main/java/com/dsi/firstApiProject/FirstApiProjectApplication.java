package com.dsi.firstApiProject;

import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.EmployeeRepository;
import com.dsi.firstApiProject.domain.Permission;
import com.dsi.firstApiProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FirstApiProjectApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(FirstApiProjectApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

//  @Bean
//	CommandLineRunner runner(EmployeeService employeeService) {
//		return args -> {
//          // Save demo data after start
//			employeeService.savePermission(new Permission(null,"add-member"));
//			employeeService.savePermission(new Permission(null, "edit-member"));
//			employeeService.savePermission(new Permission(null, "delete-member"));
//			employeeService.savePermission(new Permission(null, "view-member"));
//
//			employeeService.saveEmployee(new Employee("Ishrat", "admin", "admin@gmail.com" ,"Female", "Admin", "Full-time"));
//			//employeeService.saveEmployee(new Employee("Nushrat", "jahan", "nushrat@gmail.com" ,"Female", "Member", "Full-time"));
//
//			employeeService.addPermissionToEmployee("admin@gmail.com","add-member");
//			employeeService.addPermissionToEmployee("admin@gmail.com","delete-member");
//			employeeService.addPermissionToEmployee("admin@gmail.com","edit-member");
//			employeeService.addPermissionToEmployee("admin@gmail.com","view-member");
//
//
//		};
//	}

}
