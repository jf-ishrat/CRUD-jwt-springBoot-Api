package com.dsi.firstApiProject.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    Permission findByname(String name);
}
