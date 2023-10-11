package com.example.servicio;

import com.example.dao.AlumnoDao;
import com.example.dao.MateriaDao;
import com.example.domain.Alumno;
import com.example.domain.Materia;
import java.util.List;
//import com.example.domain.Alumno;
//import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Data
@Service
public class Modelo implements AlumnoServicios, MateriaServicios{
    
    @Autowired
    private AlumnoDao alumnoDao;
    
    
    @Autowired
    private MateriaDao materiaDao;
    
    
    
    //Servicios para Alumnos
    @Override
    @Transactional(readOnly = true)
    public List<Alumno> ObtenerAlumnos() {
        return (List<Alumno>) alumnoDao.findAll();
    }

    @Override
    @Transactional
    public void GuardarAlumno(Alumno alumno) {
        alumnoDao.save(alumno);
    }

    @Override
    @Transactional
    public void EliminarAlumno(Alumno alumno) {
        alumnoDao.delete(alumno);
    }

    @Override
    @Transactional(readOnly = true)
    public Alumno AlumnoF(Alumno alumno) {
        return alumnoDao.findById(alumno.getNC()).orElse(null);
    }
    
    //Servicios para Materias

    @Override
    public List<Materia> ObtenerMaterias() {
        return (List<Materia>) materiaDao.findAll();
    }

    @Override
    public void GuardarMateria(Materia materia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void EliminarMateria(Materia materia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Materia MateriaF(Materia materia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
