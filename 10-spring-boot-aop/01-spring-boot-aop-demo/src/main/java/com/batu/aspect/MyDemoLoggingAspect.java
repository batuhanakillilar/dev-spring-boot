package com.batu.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    //@Before("execution(public void add*())")//add ile başlayan public void fonksiyonlardan önce çalışır
    //@Before("execution(void add*())")// add ile başlayan void return type'lı fonksiyonlardan önce çalışır
    //@Before("execution(* add*())") // tüm return type'lardaki add ile başlayan fonksiyonlardan önce çalışır
    //@Before("execution(* add*(..))") //match any type parameters
    //@Before("execution(* add*(..))") //match any type parameters
    //@Before("execution(* add*(com.batu.Account, ..))") //bir tane account objesi ve any number of arguments alıyor
    @Before("execution(* com.batu.dao.*.*(..))") //match any methods in a given package
    public void beforeAddAccount() {

        System.out.println("\n ===> Executing @Before advice on addAccount()");

    }


}
