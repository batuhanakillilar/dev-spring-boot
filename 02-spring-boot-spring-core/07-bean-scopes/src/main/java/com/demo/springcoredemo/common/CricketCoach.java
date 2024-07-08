package com.demo.springcoredemo.common;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  // marks the class as a spring bean and makes it available for dependency injection
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //default olarak singleton olan scope'u prototype'a çevirdik
// Prototype : New object instances for each injection
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {

        return "Practice fast bowling for 15 minutes!!!";
    }
}
