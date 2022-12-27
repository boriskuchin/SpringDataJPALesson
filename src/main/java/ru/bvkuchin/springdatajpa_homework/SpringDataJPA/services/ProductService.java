package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.Product;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }

    public List<Product> filterProductByCost(Double min, Double max) {
        return repository.filterBetween(min, max);
    }

    @Transactional
    public void changeQuantity(Integer delta, Long id) {
        Product p = repository.getProductsById(id);
        if ((p.getQuantity() > 0) || ((p.getQuantity() == 0) && delta>0)) {
            repository.updateQuantityById(delta, id);
        }
    }

    public Product  addProduct(Product product) {
        return repository.saveAndFlush(product);
    }
}
