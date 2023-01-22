package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.security;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class AuthResponseDTO {

    private String token;

}
