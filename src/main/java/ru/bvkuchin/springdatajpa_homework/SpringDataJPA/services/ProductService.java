package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.Product;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.ProductDTO;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.repositories.ProductRepository;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.repositories.specifications.ProductSpecifications;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }



    public Page<Product> find (Double minCost, Double maxCost, String namePart, Long id, Integer page) {

        Specification<Product> specification = Specification.where(null);

        if (minCost != null) {
            specification= specification.and(ProductSpecifications.costGreaterOrEqualTo(minCost));
        }
        if (maxCost != null) {
            specification= specification.and(ProductSpecifications.costlessOrEqualTo(maxCost));
        }
        if (namePart != null) {
            specification = specification.and(ProductSpecifications.nameLike(namePart));
        }
        if (id != null) {
            specification = specification.and(ProductSpecifications.idEqualTo(id));
        }
        return repository.findAll(specification, PageRequest.of(page - 1, 50));
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

//    @Transactional
//    public void changeQuantity(Integer delta, Long id) {
//        Product p = repository.getProductsById(id);
//        if ((p.getQuantity() > 0) || ((p.getQuantity() == 0) && delta>0)) {
//            repository.updateQuantityById(delta, id);
//        }
//    }

    public Product  addProduct(Product product) {
        return repository.saveAndFlush(product);
    }
}
