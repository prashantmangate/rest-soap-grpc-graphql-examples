package com.springsecuritydemo.springsecurityapp.service;

import com.springsecuritydemo.springsecurityapp.model.Authorities;
import com.springsecuritydemo.springsecurityapp.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    private static final String ROLE_USER = "ROLE_USER";
    @Autowired
    AuthoritiesRepository authoritiesRepository;

    public Authorities addUserRole(String username){
        Authorities userRoles = new Authorities();
        userRoles.setUsername(username);
        userRoles.setAuthority(ROLE_USER);
        return authoritiesRepository.save(userRoles);
    }
}
