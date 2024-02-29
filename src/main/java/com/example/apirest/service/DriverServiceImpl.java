package com.example.apirest.service;

import com.example.apirest.DTO.DriverDTO;
import com.example.apirest.DTO.DriverDTOMapper;
import com.example.apirest.Pagers.DriverPager;
import com.example.apirest.model.Driver;
import com.example.apirest.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// SERVICE IMPLEMENTATION
// Implementación de los métodos del Service.

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository repository;
    private final DriverDTOMapper driverDTOMapper;
    private final DriverPager driverPager;

    @Autowired  // Inyecta el repositiorio y lo usa
    public DriverServiceImpl(DriverRepository repository, DriverDTOMapper driverDTOMapper, DriverPager driverPager) {
        this.repository = repository;
        this.driverDTOMapper = driverDTOMapper;
        this.driverPager = driverPager;
    }

    // Cambiamos para utilizar el DTO
    @Override
    public List<DriverDTO> getAllDriversDTO() {
        // Cambiamos el getAllDrivers para que mapee al DTO
        return repository.findAll()
                .stream()
                .map(driverDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DriverDTO> getDriverByCodeDTO(String code) {
        // Igual que antes, cambiamos para que mapee al DTO
        return repository.findByCodeIgnoreCase(code)
                .map(driverDTOMapper);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return repository.findAll();
    }

    @Override
    public Optional<Driver> getDriverByCode(String code) {
        return repository.findByCodeIgnoreCase(code);
    }

    @Override
    public void deleteDriverByCode(String code) {
        repository.removeByCodeIgnoreCase(code);
    }

    @Override
    public Driver saveDriver(Driver driver) {
        return this.repository.save(driver);
    }

    @Override
    public Page<Driver> getAllPaged(int page, int size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return driverPager.findAllProjectedBy(pageable);
    }

}
