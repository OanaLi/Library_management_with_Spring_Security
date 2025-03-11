package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"roles"})
    Optional<User> findByUsername(String username);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"roles"})
    List<User> findAll();


    //principal este un obiect disponibil în contextul de securitate Spring Security și reprezintă utilizatorul autentificat.
    //principal.username extrage username-ul din obiectul principal.
    @Query("SELECT u FROM User u WHERE u.username = ?#{ principal.username}")
    Optional<User> findLoginUser();

    boolean existsByEmailAddress(String emailAddress);
}