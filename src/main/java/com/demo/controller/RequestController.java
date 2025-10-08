package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.service.EmailService;

@Controller
public class RequestController {

	
	@Autowired
	private EmailService emailService;

	@GetMapping("/requestPage")
	 
    public String requestPage(@RequestParam("emailid") String email, Model model) {
        // Pass email to Thymeleaf template
        model.addAttribute("emailid", email);
	
	    return "requestPage";
	}


}
