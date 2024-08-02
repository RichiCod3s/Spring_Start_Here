package com.example.usinggetposthttpmethods.controllers;

//A controller will call the use cases implemented by the service.
//The web app will display the product in this list on a web page, and in this list the user can add more products.

import com.example.usinggetposthttpmethods.model.Product;
import com.example.usinggetposthttpmethods.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) { //We use DI through the controller’s constructor parameters to get the service bean from the Spring context.
        this.productService = productService;
    }


  //We map the controller action to the /products path. (Alternative) The @RequestMapping annotation, by default, uses the HTTP GET method.
    @GetMapping("/products")  //@GetMapping maps the HTTP GET request with a specific path to the controller’s action.
    public String viewProducts(Model model) { // We define a Model parameter that we use to send the data to the view.
        var products = productService.findAll(); //We get the product list from the service.
        model.addAttribute("products", products); // We send the product list to the view.

        return "products"; // We return the view name, which will be taken and rendered by the dispatcher servlet.
    }


    @PostMapping("/products")  //@PostMapping maps the HTTP POST request with a specific path to the controller’s action.
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}

/*
 @RequestMapping(path = "/products",
                  method = RequestMethod.POST)

We used the attribute method of the @RequestMapping annotation to specify the HTTP method. If you don’t set a method,
by default @RequestMapping uses HTTP GET. But because both the path and the method are essential for any HTTP call,
we want to always confirm both. For this reason, developers usually use dedicated annotations for each HTTP method
instead of @RequestMapping. For apps, you’ll often find developers using @GetMapping to map a GET request to an action,
@PostMapping for a request using HTTP POST, and so on.
*/