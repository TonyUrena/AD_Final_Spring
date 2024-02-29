package com.example.apirest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "results")
public class Result {

    // Para poder establecer una relacion many to many necesitamos declarar
    // una tabla específica para representarla, ya que las relaciones many
    // to many no existen como tal en las implementaciones de  bases de datos
    // relacionales.

    // Para modelarla necesitamos cada una de las id relacionadas en una tupla
    // que las contenga como foreign keys. Cada tupla estará tambien identificada
    // con una primary key.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultid")
    Long resultId;

    @ManyToOne
    @JoinColumn(name = "raceid")
    Race race;

    @ManyToOne
    @JoinColumn(name = "driverid")
    Driver driver;

    Integer grid;
    Integer position;
    Integer points;
}