package com.example.apirest.service;

import com.example.apirest.model.Constructor;
import com.example.apirest.repository.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorServiceImpl implements ConstructorService {

    private final ConstructorRepository repository;

    @Autowired
    public ConstructorServiceImpl(ConstructorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Constructor> getAllConstructors() {
        return repository.findAll();
    }

    @Override
    public Optional<Constructor> getConstructorByConstructorref(String constructorref) {
        return repository.findByConstructorrefIgnoreCase(constructorref);
    }

    @Override
    public void deleteConstructorByConstructorref(String constructorref) {
        repository.removeByConstructorref(constructorref);
    }

    @Override
    public Constructor saveConstructor(Constructor constructor) {
        return this.repository.save(constructor);
    }
}
