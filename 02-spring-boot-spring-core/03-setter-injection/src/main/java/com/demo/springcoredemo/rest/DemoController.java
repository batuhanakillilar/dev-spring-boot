package com.demo.springcoredemo.rest;

import com.demo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Rest Controller classlarında bunu yukarıda belirtmek gerekiyor
public class DemoController {

    //define a private field for dependency
    private Coach myCoach;

    //constructor yerine setter methodu yazıp onunla yaptık
    @Autowired
    public void setCoach(Coach coach){

        myCoach = coach;

    }
    @GetMapping("/dailyworkout")
    public String dailyWorkout() {

        return myCoach.getDailyWorkout();
    }
}
