package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.cost between :minCost and :maxCost")
    List<Product> filterBetween(Double minCost, Double maxCost);

    @Query("select p from Product p where p.cost < :cost")
    List<Product> filterLessThanCost(Double cost);

    @Query("select p from Product p where p.cost > :cost")
    List<Product> filterMoreThanCost(Double cost);
}
