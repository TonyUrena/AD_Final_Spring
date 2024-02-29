package com.example.apirest.DTO;

import com.example.apirest.model.Driver;
import org.springframework.stereotype.Service;

import java.util.function.Function;

    // Podemos declarar el mapper en su propia clase para inyectarlo en el
    // servicio que se necesite

@Service
public class DriverDTOMapper implements Function<Driver, DriverDTO> {
    @Override
    public DriverDTO apply(Driver driver) {
        return new DriverDTO(
                driver.getCode(),
                driver.getForename() + " " + driver.getSurname()
        );
    }
}
