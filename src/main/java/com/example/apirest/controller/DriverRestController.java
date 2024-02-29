package com.example.apirest.controller;

import com.example.apirest.DTO.DriverDTO;
import com.example.apirest.model.Driver;
import com.example.apirest.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    // CONTROLADOR
    // Actúa como intermediario entre el modelo y la vista
    // Puede usarse @Controller para devolver datos en una vista y
    // @RestController cuando se devuelven datos serializados (generalmente formateados en JSON)
    // En este caso se añade una capa adicional "service" que contiene la lógica de negocio con el modelo

@RestController // Recibe peticiones y devuelve respuestas
@RequestMapping("/api")
public class DriverRestController {

    private final DriverService driverService;

    @Autowired
    public DriverRestController(DriverService service){
        this.driverService = service;
    }

    // GetMapping para paginar
    @GetMapping("/drivers/paging")
    public ResponseEntity<List<Driver>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "driverid") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection

    ){
        Page<Driver> list = driverService.getAllPaged(page, size, sortBy, sortDirection);
        return ResponseEntity.ok(list.getContent());
    }

    // Cambiamos los GetMapping de /drivers para utilizar el DTO
        @GetMapping("/driversDTO")
        public ResponseEntity<List<DriverDTO>> getAllDTO(){
            return ResponseEntity.ok(driverService.getAllDriversDTO());
        }

        @GetMapping("/drivers")
        public ResponseEntity<List<Driver>> getAll(){
            return ResponseEntity.ok(driverService.getAllDrivers());
        }

    // GET http://localhost:8080/api/drivers/alo

        @GetMapping("/drivers/{code}")
        public ResponseEntity<Driver> getByCode(@PathVariable String code){
            return this.driverService.getDriverByCode(code)     // Se llama al método del servicio, que a su vez llamará al del Repositorio
                    .map(ResponseEntity::ok)                    // Si el resultado no es nulo se crea un ResponseEntity con un código HTTP 200 (OK) y el objeto driver en el cuerpo de la respuesta
                    .orElse(ResponseEntity.notFound().build()); // Si el resultado es nulo se devuelve un 404.
                                                                // build() se utiliza cuando hay que devolver un ResponseEntity sin un objeto en el cuerpo, en este caso a raíz de recibir un 404.
        }
    @GetMapping("/driversDTO/{code}")
    public ResponseEntity<DriverDTO> getByCodeDTO(@PathVariable String code){
        return this.driverService.getDriverByCodeDTO(code)     // Se llama al método del servicio, que a su vez llamará al del Repositorio
                .map(ResponseEntity::ok)                    // Si el resultado no es nulo se crea un ResponseEntity con un código HTTP 200 (OK) y el objeto driver en el cuerpo de la respuesta
                .orElse(ResponseEntity.notFound().build()); // Si el resultado es nulo se devuelve un 404.
                                                            // build() se utiliza cuando hay que devolver un ResponseEntity sin un objeto en el cuerpo, en este caso a raíz de recibir un 404.
    }

    // POST http://localhost:8080/api/drivers
    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver){
        if (driver.getDriverid() != null) {
            return ResponseEntity.badRequest().build();
        }
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    // PUT http://localhost:8080/api/drivers
    @PutMapping("/drivers")
    ResponseEntity<Driver> update(@RequestBody Driver driver){
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    // DELETE http://localhost:8080/api/drivers/alo
    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> deleteByCode(@PathVariable String code){
        this.driverService.deleteDriverByCode(code);
        return ResponseEntity.noContent().build();
    }
}
