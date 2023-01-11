package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.Product;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.exceptions.ResourceNotFoundException;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.repositories.CartRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CartService {

    private CartRepository cartRepository;
    private ProductService productService;

    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getItemsInCart() {
        return Collections.unmodifiableList(cartRepository.getProductList());
    }

    public void addTocart(Long id) {
        Product product = productService.getProductById(id).orElseThrow(()->new ResourceNotFoundException("No such product"));

        cartRepository.addProductToCart(product);
    }
}
