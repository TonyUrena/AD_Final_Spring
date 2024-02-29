package com.example.apirest.repository;

import com.example.apirest.model.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {

    Optional<Constructor> findByConstructorrefIgnoreCase(String constructorref);
    void removeByConstructorref(String constructorref);

}
