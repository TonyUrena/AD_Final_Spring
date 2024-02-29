package com.example.apirest.controller;

import com.example.apirest.model.Constructor;
import com.example.apirest.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConstructorRestController {

    private final ConstructorService constructorService;

    @Autowired
    public ConstructorRestController(ConstructorService constructorService) {
        this.constructorService = constructorService;
    }

    @GetMapping("/constructors")
    public ResponseEntity<List<Constructor>> getAllConstructors() {
        return ResponseEntity.ok(constructorService.getAllConstructors());
    }

    @GetMapping("/constructors/{constructorref}")
    public ResponseEntity<Constructor> getByConstructorref(@PathVariable("constructorref") String constructorref){
        return this.constructorService.getConstructorByConstructorref(constructorref)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/constructors")
    public ResponseEntity<Constructor> create(@RequestBody Constructor constructor){
        if (constructor.getConstructorId() != null) {
            return ResponseEntity.badRequest().build();
        }
        this.constructorService.saveConstructor(constructor);
        return ResponseEntity.ok(constructor);
    }

    @PutMapping("/constructors")
    public ResponseEntity<Constructor> update(@RequestBody Constructor constructor){
        this.constructorService.saveConstructor(constructor);
        return ResponseEntity.ok(constructor);
    }

    @DeleteMapping("/constructors/{constructorref}")
    public ResponseEntity<Constructor> deleteByConstructorref(@PathVariable("constructorref") String constructorref){
        this.constructorService.deleteConstructorByConstructorref(constructorref);
        return ResponseEntity.noContent().build();
    }

}
