package com.example.apirest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Entity
@Data
@Table(name="races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raceid")
    private Long raceid;
    private int year;
    private int round;

    private String name;
    private LocalDate date;
    private String time;
    private String url;

    // El OneToOne viene desde Circuit, allí es donde están establecidas las relaciones
    // Aquí sólo declaramos que la relación es de unicidad con unique = true.
    // Esto se debe a que cada una de las clases tiene un rol diferente en la relación,
    // en este caso Circuit actua como propietario de la relación y Race como la entidad
    // inversa en la relación.
    @OneToOne
    @JoinColumn(name = "circuitid", unique = true)
    private Circuit circuit;

}
