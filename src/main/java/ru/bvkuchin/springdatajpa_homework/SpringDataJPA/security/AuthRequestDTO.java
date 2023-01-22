package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.security;

import lombok.Getter;

@Getter
public class AuthRequestDTO {
    private String username;
    private String password;
}
