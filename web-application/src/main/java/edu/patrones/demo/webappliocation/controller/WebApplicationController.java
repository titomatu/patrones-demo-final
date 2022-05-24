package edu.patrones.demo.webappliocation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebApplicationController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
