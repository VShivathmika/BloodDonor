package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DAO.BloodRequestDAO;
import com.demo.repository.DonorRepository;
import com.demo.repository.UserRepository;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private BloodRequestDAO bloodRequestRepository;

    @Autowired
//    private BloodStockRepository bloodStockRepository;

    public long getTotalUsers() {
        return userRepository.count();  // Must return number of users
    }

    public long getTotalDonors() {
        return donorRepository.count();  // Must return number of donors
    }

    public long getTotalRequests() {
        return bloodRequestRepository.count(); // Must return total requests
    }
//
//    public List<BloodStock> getBloodAvailability() {
//        return bloodStockRepository.findAll(); // Must return list of blood stocks
//    }
}


