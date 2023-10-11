package com.example.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "materias")
public class Materia implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    
    @NotEmpty
    private String nombre, dias; 
    
    @NotEmpty
    private int creditos, activo;
    
}
