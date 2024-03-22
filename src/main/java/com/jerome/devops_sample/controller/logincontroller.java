package com.jerome.devops_sample.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jerome.devops_sample.service.loginservice;
import com.jerome.devops_sample.domain.*;

    @Controller
public class logincontroller {
 
    @Autowired
    private loginservice service;
 
    @GetMapping("/")
    public String api()
    {
 
        return "login";
    }
    @GetMapping("/reg")
    public String apu()
    {
 
        return "register";
    }
 
    @PostMapping("/log")
    public String login(@ModelAttribute("user") login user) {
 
        String oauthUser = service.log(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/disp";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") login user) {
        String oauthUser = service.register(user);

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/";
        } else {
            return "redirect:/reg";
        }
    }
 
    @GetMapping("/disp")
    public String display() {
        return "display";
    }
}


