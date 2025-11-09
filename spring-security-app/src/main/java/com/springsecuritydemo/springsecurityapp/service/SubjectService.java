package com.springsecuritydemo.springsecurityapp.service;

import com.springsecuritydemo.springsecurityapp.model.Student;
import com.springsecuritydemo.springsecurityapp.model.Subject;
import com.springsecuritydemo.springsecurityapp.repository.StudentRepository;
import com.springsecuritydemo.springsecurityapp.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getSubjects(PageRequest pageRequest){
        Iterator ite = subjectRepository.findAll(pageRequest).iterator();
        List<Subject> subjects = new ArrayList<>();
        while(ite.hasNext()){
            subjects.add((Subject) ite.next());
        }
        return subjects;
    }
}
