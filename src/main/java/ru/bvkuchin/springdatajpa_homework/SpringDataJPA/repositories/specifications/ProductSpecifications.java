package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.Product;

public class ProductSpecifications {
    public static Specification<Product> costGreaterOrEqualTo(Double cost) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), cost);
    }

    public static Specification<Product> costlessOrEqualTo(Double cost) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), cost);
    }

    public static Specification<Product> nameLike(String partName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), String.format(("%%%s%%"), partName));
    }

    public static Specification<Product> idEqualTo(Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }
}
