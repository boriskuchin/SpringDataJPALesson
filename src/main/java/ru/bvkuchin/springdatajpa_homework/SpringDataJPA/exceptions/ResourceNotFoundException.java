package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
