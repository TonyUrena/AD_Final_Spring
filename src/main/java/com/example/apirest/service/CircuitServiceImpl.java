package com.example.apirest.service;

import com.example.apirest.model.Circuit;
import com.example.apirest.repository.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitServiceImpl implements CircuitService{

    private final CircuitRepository repository;

    @Autowired
    public CircuitServiceImpl(CircuitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Circuit> getAllCircuits() {
        return repository.findAll();
    }

    @Override
    public Optional<Circuit> getCircuitByCircuitref(String circuitref) {
        return repository.findByCircuitref(circuitref);
    }

    @Override
    public void deleteCircuitByCircuitref(String circuitref) {
        repository.removeByCircuitref(circuitref);
    }

    @Override
    public void saveCircuit(Circuit circuit) {
        repository.save(circuit);
    }
}
