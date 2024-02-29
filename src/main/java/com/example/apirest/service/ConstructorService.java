package com.example.apirest.service;

import com.example.apirest.model.Constructor;

import java.util.List;
import java.util.Optional;

public interface ConstructorService {

    List<Constructor> getAllConstructors();
    Optional<Constructor> getConstructorByConstructorref(String constructorref);
    void deleteConstructorByConstructorref(String constructorref);
    Constructor saveConstructor(Constructor constructor);

}
