package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.exceptions;

public class AppError {

    private int statusCode;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public AppError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public AppError() {
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
