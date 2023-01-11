package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.repositories;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartRepository {
    private List<Product> productList = new ArrayList<>();

    public CartRepository() {
    }

    public void addProductToCart(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
