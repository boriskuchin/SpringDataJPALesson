package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.exceptions;

public class IncorrectRequestParameterException extends RuntimeException{
    public IncorrectRequestParameterException(String message) {
        super(message);
    }
}
