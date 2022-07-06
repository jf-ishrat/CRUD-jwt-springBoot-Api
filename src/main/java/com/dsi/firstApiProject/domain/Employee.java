package com.dsi.firstApiProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor
@AllArgsConstructor
public class Employee {

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

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Permission> permissions = new ArrayList<>();

    @Column(unique=true)
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;
    private String providerId;

}
