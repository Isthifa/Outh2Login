package com.example.oauth2login.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class User {

        @GetMapping("/hello")
        public String hello() {
                return "Hello World!";
        }

        @GetMapping("/bye")
        public String bye() {
                return "Bye World!";
        }

        @GetMapping("/name")
        public Principal user(Principal principal) {
                System.out.println("username : " + principal.getName());
                return principal;
        }
        
}
