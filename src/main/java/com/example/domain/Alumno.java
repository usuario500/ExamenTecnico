package com.example.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "NC")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  NC;
    
    
    private String nombres, apellidos, correo, carrera, telefono;
    
    
}
