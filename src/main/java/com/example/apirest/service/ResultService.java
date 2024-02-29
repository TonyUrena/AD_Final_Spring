package com.example.apirest.service;

import com.example.apirest.model.Result;

import java.util.List;
import java.util.Optional;

public interface ResultService {
    List<Result> getAllResults();
    Optional<Result> getByResultid(Long resultid);
    void deleteByResultid(Long resultid);
    void saveResult(Result result);

}
