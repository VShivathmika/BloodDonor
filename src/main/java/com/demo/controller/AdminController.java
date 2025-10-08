package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entity.BloodDonation;
import com.demo.entity.BloodRequest;
import com.demo.entity.UserInformation;
import com.demo.service.AdminService;
import com.demo.service.BloodRequestService;
import com.demo.service.DonorService;
import com.demo.service.UserService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    
    @Autowired
    private UserService userservice;
    
    @Autowired
    private BloodRequestService requestService;
    
    @Autowired
    private DonorService donorService;

    /**
     * From donor search page when “Request” button is clicked.
     */
    @GetMapping("/requestDonor")
    public String requestDonor(
            @RequestParam("donorEmail") String donorEmail,
            @RequestParam("userEmail") String requesterEmail) {

        BloodRequest request = new BloodRequest();
        request.setDonorEmail(donorEmail);
        request.setRequesterEmail(requesterEmail);
        request.setStatus("Pending");

        requestService.addRequest(request); // save to DB
        return "redirect:/DonorDetails"; // back to donor list
    }

    
   

    
    /**
     * Admin view all blood requests
     */
    @GetMapping("/viewRequests")
    public String viewRequests(Model model) {
        List<BloodRequest> requests = requestService.getAllRequests();
        model.addAttribute("requests", requests);
        return "AdminRequestDetails"; // Thymeleaf page
    }

    /**
     * Admin login validation (POST).
     *
     * - On success: redirect to /adminDashboard (or wherever the admin dashboard lives)
     * - On failure: redirect to home (/) with ?error=admin so the front-end JS will open the login modal,
     *   switch to Admin tab, and show the error message.
     */
    @PostMapping("/adminLoginValidation")
    public String adminLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes) {

        // Debugging (remove in production) - uncomment if you need to verify values:
        // System.out.println("Admin login attempt: " + username + " / " + password);

        if (adminService.validateAdmin(username, password)) {
            // Optionally pass username as a query param or set session attribute as needed
            redirectAttributes.addAttribute("username", username);
            return "redirect:/adminDashboard";
        } else {
            // Send query param so your JS in home page can open modal and show Admin error
            redirectAttributes.addAttribute("error", "admin");
            return "redirect:/";
        }
    }

    /**
     * Admin dashboard page
     */
    @GetMapping("/adminDashboard")
    public String adminDashboard() {
        return "AdminDashboard"; // your dashboard HTML page
    }
    
    @GetMapping("/admindonordetailss")
    public String donorDetails(Model model, @RequestParam(value = "addressorbloodgroup", required = false) String filter) {
        List<BloodDonation> blood;
        if (filter != null && !filter.isEmpty()) {
            blood = donorService.getDonor(filter);
        } else {
            blood = donorService.getAllDonors();
        }
        model.addAttribute("donor1", blood);
    	return "AdminDonorDetails";
    }
    
    
    @GetMapping("/adminadddonor")
    
    public String  adddonor() {
    	return "UserInformation";
    }
}
