package com.example.apirest.service;

import com.example.apirest.model.Circuit;

import java.util.List;
import java.util.Optional;

public interface CircuitService {

    List<Circuit> getAllCircuits();
    Optional<Circuit> getCircuitByCircuitref(String circuitref);
    void deleteCircuitByCircuitref(String circuitref);
    void saveCircuit(Circuit circuit);

}
