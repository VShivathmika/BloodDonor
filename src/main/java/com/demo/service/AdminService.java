package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Admin;
import com.demo.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Validate admin credentials
    public boolean validateAdmin(String username, String password) {
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        return admin != null;
    }
}
