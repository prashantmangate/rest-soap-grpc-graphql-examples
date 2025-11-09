package com.springsecuritydemo.springsecurityapp.repository;

import com.springsecuritydemo.springsecurityapp.model.Authorities;
import org.springframework.data.repository.CrudRepository;

public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {

    public Authorities findByAuthority(String authority);
    public Authorities findByUsername(String username);
}
