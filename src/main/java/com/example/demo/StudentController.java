package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Kevin Durant", 98),
            new Student(2, "Steph Curry", 94),
            new Student(3, "Draymond Green", 88),
            new Student(4, "Klay Thompson", 85)
    ));

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student)
    {
        students.add(student);
        return "New Student Created\n" + student.toString();
    }
}
