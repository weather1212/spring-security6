package com.udemy.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

  @GetMapping("/welcome")
  public String sayWelcome() {
    return "Welcome to Spring Applcation with a Security";
  }

}
