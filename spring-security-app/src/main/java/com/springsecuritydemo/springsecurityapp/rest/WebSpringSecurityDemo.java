package com.springsecuritydemo.springsecurityapp.rest;

import com.springsecuritydemo.springsecurityapp.model.Student;
import com.springsecuritydemo.springsecurityapp.model.Subject;
import com.springsecuritydemo.springsecurityapp.model.User;
import com.springsecuritydemo.springsecurityapp.service.RegisterUserService;
import com.springsecuritydemo.springsecurityapp.service.StudentService;
import com.springsecuritydemo.springsecurityapp.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebSpringSecurityDemo {

    private Logger log = LoggerFactory.getLogger("web");

    @Autowired
    RegisterUserService registerUserService;

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @PostMapping(value="/create",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addUser(@ModelAttribute User user){
        System.out.println("in add user");
        log.info(" User saved "+user.getUserName()+" "+user.getPassword());
        User userObj = registerUserService.addUser(user);
        log.info(" User saved "+userObj.getUserName());
        return "success";//registerUserService.addUser(userObj).getUserName()+" added successfully.";
    }

    @GetMapping("/getUsers")
    public List<User> getRegisteredUser(){
       return registerUserService.findUsers();
    }

    @GetMapping("/students")
    public String getStudentList(Model model){
        List<Student> students = studentService.getStudents();
        model.addAttribute("students",students);
        return "students_list";
    }

    @PutMapping("/student")
    public String updateStudent(@ModelAttribute User user, Model model){
        List<Student> students = studentService.getStudents();
        model.addAttribute("students",students);
        return "students_list";
    }

    @GetMapping(value = "/subjects/{page}/{count}")
    public String getSubjectList(@PathVariable("page") int page, @PathVariable("count") int count, Model model){
        List<Subject> subjects = subjectService.getSubjects(PageRequest.of(page, count));
        model.addAttribute("subjects",subjects);
        int prev = 0;
        if(page >0)
            prev = page - 1;

        model.addAttribute("prev",prev);
        model.addAttribute("next",page+1);
        return "subject_list";
    }


    @GetMapping("/about")
    public String getAppInfo(){
        return "about";
    }
}
