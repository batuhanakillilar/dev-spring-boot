package com.demo.springcoredemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  // marks the class as a spring bean and makes it available for dependency injection
public class CricketCoach implements Coach {

    public CricketCoach() {

        System.out.println("In constructor: " +getClass().getSimpleName());
    }
    //define init method
    @PostConstruct
    public void doMyStartupStuff(){

        System.out.println("In postConstruct: " +getClass().getSimpleName());
    }

    //define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){

        System.out.println("In preDestroy: " +getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "Practice fast bowling for 15 minutes!!!";
    }
}
