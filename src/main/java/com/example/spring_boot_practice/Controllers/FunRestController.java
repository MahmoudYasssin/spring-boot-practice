package com.example.spring_boot_practice.Controllers;

import com.example.spring_boot_practice.ConstructorInjection.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    private Coach coach;
    @GetMapping("/")
    public String sayHello()
    {
        return "Hello I am a First Rest Controller";
    }



    // Constructor Injection
    @Autowired
    public FunRestController( @Qualifier("footballCoach")Coach coach)
    {
        this.coach=coach;
    }

    //Setter Injection
    @Autowired
    public void setCoach( @Qualifier("cricketCoach")Coach coach)
    {
        this.coach=coach;
    }




    @GetMapping("/dailyWorkout")
    public String dailyWorkout()
    {
        return coach.DailyWorkout();
    }

}
