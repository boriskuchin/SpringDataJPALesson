package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.ProductDTO;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.services.CartService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<ProductDTO> getCart() {
        return cartService.getItemsInCart().stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
    }

        @PutMapping
    public void changeQuantity(@RequestParam Long id) {
        cartService.addTocart(id);
    }

}
