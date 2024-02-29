package com.example.apirest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@Table(name = "circuits")
public class Circuit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "circuitid")
    private Long circuitid;

    private String circuitref;
    private String name;
    private String location;
    private String country;
    private double lat;
    private double lng;
    private int alt;
    private String url;

    // @OneToOne Se utiliza para establecer la relación OneToOne entre Circuit y Race.
    // Indica que un objeto Circuit está asociado con exactamente un objeto Race.
    // mappedBy = "circuit" especifica que la relación inversa está en la clase Race
    // a través de la propiedad circuit.

    // @JoinColumn Se utiliza para especificar cómo se mapea la relación en la base de datos.
    // En este caso, @JoinColumn(name = "circuitid") indica que la columna circuitid
    // en la tabla races se utilizará como clave extranjera para la relación OneToOne.
    @OneToOne(mappedBy = "circuit", cascade = CascadeType.ALL)
    @JoinColumn(name = "circuitid")
    @JsonIgnore
    private Race race;

}
