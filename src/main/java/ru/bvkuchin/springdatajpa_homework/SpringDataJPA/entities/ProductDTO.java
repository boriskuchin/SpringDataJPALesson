package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities;

import jakarta.persistence.Column;

public class ProductDTO {
    private Long id;

    private String name;

    public ProductDTO() {
    }

    private Double cost;

//    private Integer quantity;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.cost = product.getCost();
//        this.quantity = product.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }
}
