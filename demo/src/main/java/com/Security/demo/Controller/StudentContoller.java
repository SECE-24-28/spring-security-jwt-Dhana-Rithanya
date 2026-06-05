package com.Security.demo.Controller;

import com.Security.demo.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentContoller {
    List<Student> student = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Dhana","Java"),
                    new Student(2,"Rithanya","React")
            )
    );
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return student;
    }
    @PostMapping("/students")
    public String addStudents(@RequestBody Student std){
        student.add(std);
        return "Successful";

    }
    @GetMapping("csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
