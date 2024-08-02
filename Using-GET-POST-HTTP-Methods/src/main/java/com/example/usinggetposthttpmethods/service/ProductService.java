package com.example.usinggetposthttpmethods.service;

import com.example.usinggetposthttpmethods.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//The web app will display the product in this list on a web page, and in this list the user can add more products.

@Service
public class ProductService {


    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> findAll() {
        return products;
    }
}
/*
This design is a simplification to allow you to focus on the discussion of the HTTP methods. Remember that a Spring
bean’s scope by default is singleton, as we discussed in chapter 5, and a web application implies multiple threads
(one for each request). Changing a list defined as an attribute of the bean would cause race condition situations in a
real-world app where more clients add products simultaneously. For now, we’ll keep our simplification, because in the
next chapters we’ll replace the list with a database, so this problem will no longer occur. But keep in mind this is a
vicious approach, and, as we discussed in chapter 5, you shouldn’t use something similar in a production-ready app.
Singleton beans aren’t thread-safe!
*/