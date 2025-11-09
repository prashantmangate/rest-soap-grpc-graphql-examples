package com.springsecuritydemo.springsecurityapp.repository;

import com.springsecuritydemo.springsecurityapp.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long> {

}
