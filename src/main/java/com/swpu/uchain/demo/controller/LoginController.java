package com.swpu.uchain.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/whoim")
    public Object whoim(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
