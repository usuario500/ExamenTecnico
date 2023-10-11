package com.example.servicio;

import com.example.dao.AlumnoDao;
import com.example.domain.Alumno;
import java.util.List;
//import com.example.domain.Alumno;
//import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Data
@Service
public class Modelo implements AlumnoServicios {
    
    @Autowired
    private AlumnoDao alumnoDao;
    
    /*public List<Alumno> ObtenerAlumnos(){
        return (List<Alumno>) alumnoDao.findAll();
    }*/

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
}
