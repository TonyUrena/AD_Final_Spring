package com.example.apirest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "constructors")
public class Constructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructorid")
    private Long constructorId;

    @Column(name = "constructorref", unique = true)
    private String constructorref;

    @Column(unique = true)
    private String name;

    private String nationality;
    private String url;

    @OneToMany(mappedBy = "constructor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Driver> driverList;

}
