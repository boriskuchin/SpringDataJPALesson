package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.security.AuthResponseDTO;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.security.AuthRequestDTO;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.security.JwtService;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public AuthResponseDTO getToken(@RequestBody AuthRequestDTO authrequestDTO) {

        log.info(String.format("Getting request from %s", authrequestDTO.getUsername()));
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authrequestDTO.getUsername(), authrequestDTO.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        return new AuthResponseDTO(token);
    }

}
