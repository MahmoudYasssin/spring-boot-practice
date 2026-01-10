package com.example.spring_boot_practice.ConstructorInjection;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String DailyWorkout() {
        return "Practice fast bowling for 45 minutes";
    }

    public String weeklyWorkout() {
        return "Practice fast bowling for 20 minutes";
    }
}
