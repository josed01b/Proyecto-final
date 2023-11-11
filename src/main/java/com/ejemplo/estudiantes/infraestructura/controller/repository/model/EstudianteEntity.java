package com.ejemplo.estudiantes.infraestructura.controller.repository.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity(name = "estudiante")
public class EstudianteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private int edad;

}
