package com.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.BloodRequest;

@Repository
public interface BloodRequestDAO extends JpaRepository<BloodRequest, Integer> {
    // JpaRepository already provides save(), findAll(), etc.
	
	
}

