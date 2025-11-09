package com.springsecuritydemo.springsecurityapp.service;

import com.springsecuritydemo.springsecurityapp.model.Student;
import com.springsecuritydemo.springsecurityapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        Iterator ite = studentRepository.findAll().iterator();
        List<Student> students = new ArrayList<>();
        while(ite.hasNext()){
            students.add((Student) ite.next());
        }
        return students;
    }
}
