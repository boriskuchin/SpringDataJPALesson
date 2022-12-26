package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.services;

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
        if ((min != null) && (max != null)) {
            return repository.filterBetween(min, max);
        } else if ((min == null) && (max != null)) {
            return repository.filterLessThanCost(max);
        } else if ((min != null) && (max == null)) {
            return repository.filterMoreThanCost(min);
        } else {
            return null;
        }
    }


}
