package com.example.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "cargas")
public class Carga implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "NC")
    private Long  NC;
    
    private int id_materia; 
    private String horario;
    
    
}
