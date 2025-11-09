package com.springsecuritydemo.springsecurityapp.rest;

import com.springsecuritydemo.springsecurityapp.model.User;
import com.springsecuritydemo.springsecurityapp.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.springsecuritydemo.springsecurityapp.rest.AppSecurityRestService.MANAGE_APP_SEC;

@RestController
@RequestMapping(MANAGE_APP_SEC)
public class AppSecurityRestService {
    public static final String MANAGE_APP_SEC = "/manage/app-sec/";

    @Autowired
    RegisterUserService registerUserService;

    @GetMapping("/appInfo")
    public String getAppDetails(){
       return "This is simple spring security rest application.";
    }

    @GetMapping("/getUsers")
    public List<User> getRegisteredUser(){
        System.out.println(registerUserService.findUsers().size());
        List<User> users = registerUserService.findUsers();
       // User user = new User();
        return users;
    }

    @PostMapping("/create")
    public String addUser(@RequestBody User user){
        System.out.println("in add user");
        System.out.println(user.toString());
        User userObj = registerUserService.addUser(user);
        return userObj.getUserName()+" added successfully.";
    }

}
