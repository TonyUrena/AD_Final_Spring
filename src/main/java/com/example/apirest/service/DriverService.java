package com.example.apirest.service;

    // SERVICE
    // Interfaz llamada desde el controller que contiene la lógica de negocio con el modelo.


import com.example.apirest.DTO.DriverDTO;
import com.example.apirest.Pagers.DriverPager;
import com.example.apirest.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    // Cambiamos para usar el DTO
    List<DriverDTO> getAllDriversDTO();
    Optional<DriverDTO> getDriverByCodeDTO(String code);

    List<Driver> getAllDrivers();
    Optional<Driver> getDriverByCode(String code);
    void deleteDriverByCode(String code);
    Driver saveDriver(Driver driver);

    Page<Driver> getAllPaged(int page, int size, String sortBy, String sortDirection);
}
