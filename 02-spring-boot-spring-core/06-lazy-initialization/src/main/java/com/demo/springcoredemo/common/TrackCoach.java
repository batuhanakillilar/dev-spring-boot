package com.demo.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // Lazy olarak belirttiğimiz için sadece çağırıldığında, kullanıldığında çalışıyor
// application.properties'e spring.main.lazy-initialization=true eklersek hepsi lazy çalışır
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor: " +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {

        return "Run a hard 5k!";
    }
}
