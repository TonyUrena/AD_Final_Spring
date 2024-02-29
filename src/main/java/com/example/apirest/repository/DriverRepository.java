package com.example.apirest.repository;

import com.example.apirest.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

    // REPOSITORY
    // Extiende de JpaRepository, la cual contiene métodos CRUD estándar
    // Se encarga de la persistencia y la interacción con la base de datos.
    // Spring Data JPA analiza el nombre de los métodos y realiza consultas SQL automáticamente
    // Pueden crearse métodos personalizados con la anotación @Query

@Repository

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByCodeIgnoreCase(String code);
    void removeByCodeIgnoreCase(String code);

}
