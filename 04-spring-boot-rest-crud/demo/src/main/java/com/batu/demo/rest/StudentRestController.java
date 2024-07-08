package com.batu.demo.rest;

import com.batu.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    //define @postconstruct to load the student data... only once
    @PostConstruct
    public void loadData(){

        students = new ArrayList<>();
        students.add(new Student("Batuhan", "Akillilar"));
        students.add(new Student("Kanay", "Arat"));
        students.add(new Student("Polat", "Yildirim"));

    }

    //define an endpoint for /students

    @GetMapping("/students")
    List<Student> getStudents() {

        return students;
    }

    //retrieve a single student by id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if(studentId < 0 || studentId > students.size()) {
            throw new StudentNotFoundException("Student not found" + studentId);
        }
        return students.get(studentId);

        }
    //add an exception handler



    }


