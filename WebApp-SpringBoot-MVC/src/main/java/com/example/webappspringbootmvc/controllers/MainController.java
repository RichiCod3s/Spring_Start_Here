package com.example.webappspringbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//The @Controller stereotype annotation marks this class as Spring MVC controller and adds a bean of this type to the Spring context.
@Controller
public class MainController {


    @RequestMapping("/home")//We assign the controller’s action to an HTTP request path.

    public String home(Model page) { //The action method defines a parameter of type Model that stores the data the controller sends to the view.
        page.addAttribute("username", "Aaron");
        page.addAttribute("color", "red");// We add the data we want the controller to send to the view.

        return "home.html"; //The controller’s action returns the view to be rendered into the HTTP response.
    }
}
/*
parameter of type Model stores the data we want the controller to send to the view.
In this Model instance, we add the values we want to send to the view and identify each of them with a unique name (also referred to as key).
To add a new value that the controller sends to the view, we call the addAttribute() method.
The first parameter of the addAttribute() method is the key; the second parameter is the value you send to the view.

notes:
We had to import thymeleaf to maven (ii used spring set up tools)
HTML file in resources/templates file (dynamic view)


To test if everything works, start the application and access the web page in a browser: http://localhost:8080/home
 */