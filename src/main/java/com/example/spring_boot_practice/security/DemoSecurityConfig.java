package com.example.spring_boot_practice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    {
        UserDetails Ahmed= User.builder()
                .username("Ahmed")
                .password("{noop}test123")
                .roles("User")
                .build();

        UserDetails Mahmoud= User.builder()
                .username("Mahmoud")
                .password("{noop}test123")
                .roles("ADMIN")
                .build();

        UserDetails Ali= User.builder()
                .username("Ali")
                .password("{noop}test123")
                .roles("MANGER")
                .build();

        return new InMemoryUserDetailsManager(Ahmed,Mahmoud,Ali);


    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception
    {
        httpSecurity.authorizeHttpRequests(configurer -> configurer

                        .requestMatchers(HttpMethod.GET,"/findAll").hasRole("User") //Ahmed
                        .requestMatchers(HttpMethod.POST,"/save").hasRole("MANGER") //Ali
                        .requestMatchers(HttpMethod.DELETE,"/delete/{id}").hasRole("ADMIN") //Mahmoud





                );
        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf-> csrf.disable());

        return httpSecurity.build();

    }
}
