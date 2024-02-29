package com.example.apirest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

// MODELO
    // Representa los datos como una entidad de una base de datos en el contexto JPA
    // No contiene lógica de presentación ni interacción con las vistas.

@Entity     // Indica que esta clase mapea a una tabla de una BBDD
@Data       // Anotación de Lombok, genera métodos comunes como tostring, equals, etc https://projectlombok.org/features/Data
@Table(name="drivers") // Especifica el nombre de la BBDD. Si no se utiliza, JPA utilizará el nombre de la clase como nombre de la tabla
public class Driver {
    @Id     // Especifica la clave primaria. Cuando JPA interactua con la BDD usa la info de Id para las operaciones de persistencia y recuperacion basadas en clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el Id se genera automaticamente. IDENTITY suele usar autoincremento
    @Column(name = "driverid")  // Especifica las propiedades de la columna
    private Long driverid;

    @Column(unique = true) // Especifica las propiedades de una columna asociada a un campo de una entidad. Si no se especifica "name" usa el nombre del campo
    private String code;
    private String forename;
    private String surname;
    @JsonProperty("dateOfBirth") // Anotación de Jackson. Cuando se serialicen los datos a JSON, el campo dob pasará a llamarse dateOfBirth
    private LocalDate dob;
    private String nationality;
    private String url;

    @ManyToOne
    @JoinColumn(name = "constructorid")
    @JsonIgnoreProperties("drivers")
    private Constructor constructor;

}
