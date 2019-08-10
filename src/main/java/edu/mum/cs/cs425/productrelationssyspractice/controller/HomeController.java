package edu.mum.cs.cs425.productrelationssyspractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/","/prodsys/home"})
    public String displayHome(){
        return "index";
    }
}
