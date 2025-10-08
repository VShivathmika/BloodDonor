package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.service.DashboardService;


@Controller
public class AdminDashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/adminDashboardLive")
    public String showDashboard(Model model) {
   
        model.addAttribute("totalUsers", dashboardService.getTotalUsers());
        model.addAttribute("totalDonors", dashboardService.getTotalDonors());
        model.addAttribute("totalRequests", dashboardService.getTotalRequests());
//        model.addAttribute("bloodAvailability", dashboardService.getBloodAvailability());
        return "adminDashboard"; // your HTML file
    }
}
