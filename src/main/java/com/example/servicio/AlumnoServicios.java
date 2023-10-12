package com.example.servicio;

import com.example.domain.Alumno;
import java.util.List;

public interface AlumnoServicios {
    
    public List<Alumno> ObtenerAlumnos();
    
    public void GuardarAlumno(Alumno alumno);
    
    public Alumno AlumnoF(Alumno alumno);
    
}
