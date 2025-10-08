package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    // Custom query to find by username and password
    Admin findByUsernameAndPassword(String username, String password);
}
