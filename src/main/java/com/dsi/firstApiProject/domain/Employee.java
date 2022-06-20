package com.dsi.firstApiProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
@Entity @Data
public class Employee {

    public Employee(){

    }

    public Employee(String firstName, String lastName,String email, String gender, String role, String status){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.role = role;
        this.status = status;
        this.username = email;
      //  this.password = lastName;

        this.password = new BCryptPasswordEncoder().encode(lastName);

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    private String firstName;
    @Column(unique=true)
    private String email;
    private String lastName;
    private String gender;
    private String role;
    private String status;
    @Column(unique=true)
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;

}
