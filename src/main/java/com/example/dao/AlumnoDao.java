package com.example.dao;

import com.example.domain.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoDao extends CrudRepository<Alumno, Long>{
    
}
