package com.dsi.firstApiProject;

import com.dsi.firstApiProject.domain.Employee;
import com.dsi.firstApiProject.domain.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstApiProjectApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(FirstApiProjectApplication.class, args);
	}

   @Bean
	CommandLineRunner runner() {
		return args -> {
          // Save demo data after start
			employeeRepository.save(new Employee("Most. Jannatul", "Ferdousi", "Female", "admin", "Full-time"));
			employeeRepository.save(new Employee("Safayet", "Jamil", "Male", "member", "Full-time"));

		};
	}

}
