package com.example.apirest.service;

import com.example.apirest.model.Result;
import com.example.apirest.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository repository;

    @Autowired
    public ResultServiceImpl(ResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Result> getAllResults() {
        return repository.findAll();
    }

    @Override
    public Optional<Result> getByResultid(Long resultid) {
        return repository.findByResultId(resultid);
    }

    @Override
    public void deleteByResultid(Long resultid) {
        repository.removeByResultId(resultid);
    }

    @Override
    public void saveResult(Result result) {
        repository.save(result);
    }

}
