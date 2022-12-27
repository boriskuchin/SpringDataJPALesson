package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.Product;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.exceptions.IncorrectRequestParameterException;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.exceptions.ResourceNotFoundException;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return service.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("No such product id"));
    }

    @GetMapping("/products/delete")
    public void deleteProductByID(@RequestParam Long id) {
        service.deleteProductById(id);
    }

    @PostMapping("/products/filter")
    public List<Product> filterProductByCost(@RequestParam(required = false, defaultValue = "0") Double min, @RequestParam(required = false, defaultValue = "999999999") Double max) {
        List<Product> products = service.filterProductByCost(min, max);
        return products;
    }

    @PostMapping("/products/change_quantity")
    public void changeQuantity(@RequestParam Integer delta, @RequestParam Long id) {
        service.changeQuantity(delta, id);
    }

    @PostMapping("/productAdd")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }
}
