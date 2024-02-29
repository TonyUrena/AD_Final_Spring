package com.example.apirest.repository;

import com.example.apirest.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaceRepository extends JpaRepository<Race, Long> {

    Optional<Race> findByRaceid(Long raceid);
    void removeByRaceid(Long raceid);

}
