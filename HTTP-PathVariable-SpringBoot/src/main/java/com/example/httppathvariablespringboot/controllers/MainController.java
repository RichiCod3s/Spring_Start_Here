package com.example.httppathvariablespringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {


    @GetMapping("/home/{color}") //To define a path variable, you assign it a name and put it in the path between curly braces.
    public String home(@PathVariable String color, Model page) { //You mark the parameter where you want to get the path variable value with the @PathVariable annotation. The name of the parameter must be the same as the name of the variable in the path.
        page.addAttribute("username", "Aaron");
        page.addAttribute("color", color);
        return "home.html";
    }
}
/*
Run the app and access the page in your browser with different values for the color:
http://localhost:8080/home/blue
http://localhost:8080/home/red
http://localhost:8080/home/green
 */