package com.demo.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Rest Controller classlarında bunu yukarıda belirtmek gerekiyor
public class DemoController {

    //define a private field for dependency
    private Coach myCoach;

    //define a constructor for dependency injection
    @Autowired
    public DemoController(Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
