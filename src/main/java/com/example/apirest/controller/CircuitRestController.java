package com.example.apirest.controller;

import com.example.apirest.model.Circuit;
import com.example.apirest.service.CircuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CircuitRestController {

    private final CircuitService circuitService;

    @Autowired
    public CircuitRestController(CircuitService service) {
        this.circuitService = service;
    }

    @GetMapping("/circuits")
    public ResponseEntity<List<Circuit>> getAll(){
        return ResponseEntity.ok(circuitService.getAllCircuits());
    }

    @GetMapping("/circuits/{circuitref}")
    public ResponseEntity<Circuit> getByCircuitref(@PathVariable String circuitref){
        return this.circuitService.getCircuitByCircuitref(circuitref)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/circuits")
    public ResponseEntity<Circuit> create(@RequestBody Circuit circuit){
        if (circuit.getCircuitref() != null) {
            return ResponseEntity.badRequest().build();
        }
        this.circuitService.saveCircuit(circuit);
        return ResponseEntity.ok(circuit);
    }

    @PutMapping ("/circuits")
    ResponseEntity<Circuit> update(@RequestBody Circuit circuit){
        this.circuitService.saveCircuit(circuit);
        return ResponseEntity.ok(circuit);
    }

    @DeleteMapping("/circuits/{circuitref}")
    public ResponseEntity<Circuit> deleteByCircuitref(@PathVariable String circuitref){
        this.circuitService.deleteCircuitByCircuitref(circuitref);
        return ResponseEntity.noContent().build();
    }

}
