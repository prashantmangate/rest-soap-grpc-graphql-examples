package com.springsecuritydemo.springsecurityapp.repository;

import com.springsecuritydemo.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //public List<User> findUsers();

    public User findByUserName(String username);
}
