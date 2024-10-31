package com.proyecto.ieti.pemc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {
    @GetMapping("/login")
    public String getMethodName() {
        return "login.html";
    }

    
}
