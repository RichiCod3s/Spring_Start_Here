package com.example.WebStarter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(){
       return "home.html";
    }
}

//display page on local host
//http://localhost:8080/home