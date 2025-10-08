package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entity.BloodDonation;
import com.demo.entity.UserInformation;
import com.demo.service.DonorService;
import com.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private DonorService donorService;

    // ====================== USER REGISTRATION ======================

    @PostMapping("/user")
    public String registerUser(@ModelAttribute UserInformation user) {
        userService.userRegistrationData(user);
        // Redirects to home page with ?registered=true (handled in JS)
        return "redirect:/?registered=true";
    }

    @RequestMapping("/alluserDetails")
    public String getAllUserDetails(Model model) {
        List<UserInformation> list = userService.allUserDetails();
        model.addAttribute("alluserdetails", list);
        return "DisplayAllUserDetails";
    }

    @RequestMapping("/userByMobileNumber")
    public String getMobileNumber(@RequestParam("mobileNumber") long mobilenumber, Model model) {
        List<UserInformation> list = userService.getUserDetailsByUsingMobilenumber(mobilenumber);
        model.addAttribute("alluserdetails", list);
        return "DisplayAllUserDetails";
    }

    @RequestMapping("/userByAnyAttribute")
    public String getUserDetailsByUsingAnyAttribute(
            @RequestParam("userNameorgenderoraddressorpasswordoremailId") String filter, Model model) {
        List<UserInformation> list = userService.filterallUserDetails(filter);
        model.addAttribute("alluserdetails", list);
        return "DisplayAllUserDetails";
    }

    @RequestMapping("/deleteDetails")
    public String deleteDetails(@RequestParam("emailId") String emailid) {
        userService.deleteUserDetails(emailid);
        return "redirect:/alluserDetails";
    }

    @RequestMapping("/display")
    public String getDetails(UserInformation userInformation, Model model) {
        userService.update(userInformation);
        return "redirect:/alluserDetails";
    }

    @RequestMapping("/updateDetails")
    public String updateDetails(@RequestParam("emailid") String emailid, Model model) {
        UserInformation user = userService.updateUserDetails(emailid);
        model.addAttribute("user", user);
        return "FetchUserDetailsForUpdating";
    }

    // ====================== LOGIN ======================

    @RequestMapping("/userLogin")
    public String userLoginPage() {
        return "UserLogin";
    }

    @RequestMapping("/userLoginValidation")
    public String loginValidation(@RequestParam("emailid") String emailid,
                                  @RequestParam("password") String password,
                                  Model model,
                                  RedirectAttributes redirectAttributes) {

        if (userService.getDetailsByEmailidAndValidation(emailid, password)) {
            UserInformation user = userService.updateUserDetails(emailid);
            model.addAttribute("email", emailid);
            model.addAttribute("username", user.getUsername());
            return "MenuPage";
        } else {
            redirectAttributes.addAttribute("error", "user");
            return "redirect:/";
        }
    }

    // ====================== DONOR SECTION ======================

    @RequestMapping("/MenuPage")
    public String welcomePage() {
        return "DonorRegistrationPage";
    }

    @RequestMapping("/getDetails")
    public String getUserDetails(@RequestParam("emailid") String emailid, Model model) {
        UserInformation user = userService.updateUserDetails(emailid);
        model.addAttribute("user", user);
        return "DonorRegistrationPage";
    }



    @RequestMapping("/insertDonorDetails")
    public String insertDonorDetails(BloodDonation bloodDonation) {
        donorService.donorRegistrationData(bloodDonation);
        return "ThankYouPage";
    }

    @RequestMapping("/DonorDetails")
    public String donorDetails(Model model, @RequestParam(value = "addressorbloodgroup", required = false) String filter) {
        List<BloodDonation> blood;
        if (filter != null && !filter.isEmpty()) {
            blood = donorService.getDonor(filter);
        } else {
            blood = donorService.getAllDonors();
        }
        model.addAttribute("donor1", blood);
        return "DonorDetails";
    }

    @RequestMapping("/getDonorDetails")
    public String getDonorDetails(@RequestParam("addressorbloodgroup") String filter, Model model) {
        List<BloodDonation> blood = donorService.getDonor(filter);
        model.addAttribute("donor1", blood);
        return "DonorDetails";
    }

    // ====================== REQUEST PAGE ======================

    @RequestMapping("/requestPage")
    public String getRequestPage(@RequestParam("emailid") String emailid, Model model) {
        model.addAttribute("emailid", emailid);
        return "requestPage";
    }

    // ====================== LOGOUT / HOME ======================

    @GetMapping("/userlogout")
    public String userlogout() {
        return "BloodDonationProject";
    }

    @RequestMapping("/")
    public String home() {
        return "BloodDonationProject";
    }
}
