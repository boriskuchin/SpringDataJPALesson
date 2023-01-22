package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
