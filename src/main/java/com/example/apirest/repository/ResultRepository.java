package com.example.apirest.repository;

import com.example.apirest.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Long> {

    Optional<Result> findByResultId(Long resultid);
    void removeByResultId(Long resultid);

}
