package com.jerome.devops_sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerome.devops_sample.repository.loginrepo;
import com.jerome.devops_sample.domain.login;

@Service
public class loginservice {
    @Autowired
    private loginrepo rep;

    public String log(String username, String password) {
        login user=rep.findByUsernameAndPassword(username, password);
        if(user!=null) {
            return "Successfully logged in";
        }
        else{
            return "Error";
        }
    }
    public String register(login log) {
        login user=rep.save(log);
        if(user!=null) {
            return "Successfully logged in";
        }
        else {
            return "Error";
        }
    }
}