package com.demo.springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach() {

        System.out.println("In Constructor: " + this.getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim a 1000m as a warm-up";
    }
}
