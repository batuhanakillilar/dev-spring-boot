package com.demo.springcoredemo.common;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary    //Bunu kullanması gerektiğini belirtmiş oluyoruz
@Component  // marks the class as a spring bean and makes it available for dependency injection
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {

        return "Practice fast bowling for 15 minutes!!!";
    }
}
