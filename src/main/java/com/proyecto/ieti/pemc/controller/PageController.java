package com.proyecto.ieti.pemc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {
    @CrossOrigin
    @GetMapping("/login")
    public String getMethodName() {
        return "login.html";
    }
}
