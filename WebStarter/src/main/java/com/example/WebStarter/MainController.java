package com.example.WebStarter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// tells Spring this is the controller class
@Controller
public class MainController {

    //maps this page to /home
    @RequestMapping("/home")
    public String home(){ // returns String value of the html file
       return "home.html";
    }
}

//display page on local host
//http://localhost:8080/home