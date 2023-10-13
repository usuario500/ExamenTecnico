package com.example.servicio;

import com.example.domain.Alumno;
import com.example.domain.Materia;
import java.util.List;

public interface MateriaServicios {
    
    public List<Materia> ObtenerMaterias();
    
    public void GuardarMateria(Materia materia);
    
    public Materia MateriaF(Materia materia);
    
    public List<Materia> ObtenerMateriasCarga(Alumno alumno);
    
}
