package edu.patrones.demo.webappliocation.controller;

import edu.patrones.demo.dto.OTPRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class WebApplicationController {

    @RequestMapping("/")
    public String index(Model model){
        //return "index";
        OTPRequestDto otpRequestDto = new OTPRequestDto();
        model.addAttribute("otpRequestDto", otpRequestDto);

        return "otp";
    }

    @GetMapping("/otp")
    public String otp(){
        return "otp";
    }
}
