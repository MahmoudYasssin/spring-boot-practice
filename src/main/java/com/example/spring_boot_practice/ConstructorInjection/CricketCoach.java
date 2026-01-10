package com.example.spring_boot_practice.ConstructorInjection;

import org.springframework.cache.Cache;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component//mark this class as a Bean and make it available for (DI)
public class CricketCoach implements Coach {

    @Override
    public String DailyWorkout()
    {
        return "Practice fast bowling for 15 minutes  ";
    }
}
