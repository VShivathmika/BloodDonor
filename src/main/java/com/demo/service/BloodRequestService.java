package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DAO.BloodRequestDAO;
import com.demo.entity.BloodRequest;

@Service
public class BloodRequestService {

    @Autowired
    private BloodRequestDAO requestDAO;

    public void addRequest(BloodRequest request) {
        requestDAO.save(request);
    }

    public List<BloodRequest> getAllRequests() {
        return requestDAO.findAll();
    }
    public long countRequests() {
        return requestDAO.count();
    }
}
