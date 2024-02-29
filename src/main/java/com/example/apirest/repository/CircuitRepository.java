package com.example.apirest.repository;

import com.example.apirest.model.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CircuitRepository extends JpaRepository<Circuit, String> {

    Optional<Circuit> findByCircuitref(String circuitref);
    void removeByCircuitref(String circuitref);

}
