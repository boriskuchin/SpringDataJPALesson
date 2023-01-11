package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.Product;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.ProductDTO;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.exceptions.IncorrectRequestParameterException;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.exceptions.ResourceNotFoundException;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ProductDTO> find(@RequestParam(required = false, defaultValue = "1") Integer page,
                                 @RequestParam(required = false) Double minCost,
                                 @RequestParam(required = false) Double maxCost,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Long id) {
        return service.find(minCost, maxCost, name, id, page).map(product -> new ProductDTO(product));
    }


    @GetMapping("/{id}")
    public ProductDTO getProductByID(@PathVariable Long id) {
        return service.getProductById(id).map(product -> new ProductDTO(product)).orElseThrow(() -> new ResourceNotFoundException("No such product id"));
    }

    @DeleteMapping
    public void deleteProductByID(@RequestParam Long id) {
        service.deleteProductById(id);
    }

//    @PutMapping
//    public void changeQuantity(@RequestParam Integer delta, @RequestParam Long id) {
//        service.changeQuantity(delta, id);
//    }

    @PostMapping
    public Product addProduct(@RequestBody ProductDTO productDTO) {
        return service.addProduct(new Product(productDTO));
    }

}
