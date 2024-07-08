package com.example.getvaluehttprequestparameter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(@RequestParam String color, ////We define a new parameter for the controller’s action method and annotate it with @RequestParam.
                       Model page){  //We also add the Model parameter that we use to send data from the controller to the view.
        page.addAttribute("username", "Aaron");
        page.addAttribute("color", color);// The controller passes the color sent by the client to the view.
        return "home.html";
    }
}
/*
Run the application and access the /home path. To set the request parameter’s value, you need to use the next snippet’s syntax:

http://localhost:8080/home?color=blue
http://localhost:8080/home?color=green
http://localhost:8080/home?color=purple


You can add a new parameter to the controller’s action to get this parameter as well. The next code snippet shows this change.
@RequestMapping("/home")
public String home(
        @RequestParam(required = false) String name,❶
        @RequestParam(required = false) String color, Model page) {
    page.addAttribute("username", name); ❷
    page.addAttribute("color", color);
    return "home.html";

    ❶ Gets the new request parameter “name”
    ❷ Sends the “name” parameter’s value to the view
}
}

http://localhost:8080/home?color=purple&name=Jane
*/


