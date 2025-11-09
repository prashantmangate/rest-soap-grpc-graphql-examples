package com.springsecuritydemo.springsecurityapp.service;

import com.springsecuritydemo.springsecurityapp.model.User;
import com.springsecuritydemo.springsecurityapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RegisterUserService {

    private Logger log = LoggerFactory.getLogger("service");

    @Autowired
    private UserRepository userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    UserRoleService userRoleService;

    public User addUser(User user){
        String encodedPwd = passwordEncoder.encode(user.getPassword());
        User userObj = new User(user.getFirstName(),user.getLastName(),user.getEmail(),user.getMobile(),user.getDob(),user.getUserName(),encodedPwd);
        userObj.setEnabled(true);
        User savedUSer = userRepository.save(userObj);
        userRoleService.addUserRole(savedUSer.getUserName());
        return savedUSer;
    }

    public List<User> findUsers(){
        Iterator<User> ite = userRepository.findAll().iterator();
        List<User> lstUser = new ArrayList<>();
        while(ite.hasNext()){
            User user = ite.next();
            if(user.isEnabled())
                lstUser.add(user);
        }
        return lstUser;
    }
}
