package com.example.oauth2login.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize->authorize
                        .requestMatchers("/").permitAll() //permit all requests to the root path
                        .anyRequest().authenticated()) //all other requests must be authenticated
                .oauth2Login(withDefaults()) //this is the line that enables OAuth2 Login
                .formLogin(withDefaults()) //this is the line that enables form based login
                .build(); //this is the line that builds the SecurityFilterChain
    }
}
