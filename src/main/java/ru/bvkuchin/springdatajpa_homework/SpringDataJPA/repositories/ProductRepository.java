package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("select p from Product p where p.cost between :minCost and :maxCost")
    public List<Product> filterBetween(Double minCost, Double maxCost);

//    @Modifying
//    @Query("update Product p set p.quantity = p.quantity + :delta where p.id = :id")
//    public void updateQuantityById(Integer delta, Long id);

    public Product getProductsById(Long id);
}
