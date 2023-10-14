package com.example.servicio;

import com.example.dao.AlumnoDao;
import com.example.dao.CargaDao;
import com.example.dao.MateriaDao;
import com.example.domain.Alumno;
import com.example.domain.Carga;
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
 public class Modelo implements AlumnoServicios, MateriaServicios, CargaServicios{
    
    @Autowired
    private AlumnoDao alumnoDao;
    
    
    @Autowired
    private MateriaDao materiaDao;
    
    
    @Autowired
    private CargaDao cargaDao;
    
    
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
         materiaDao.save(materia);
    }

    @Override
    public Materia MateriaF(Materia materia) {
        return materiaDao.findById(materia.getId()).orElse(null);
    }
    
    //SErvicios de Carga

    @Override
    public List<Carga> ObtenerCarga(Alumno alumno) {
        int aux = alumno.getNC().intValue();
        return (List<Carga>) cargaDao.buscarCarga(aux);
    }
    
    @Override
    public List<Materia> ObtenerMateriasCarga(Alumno alumno) {
        Long aux = alumno.getNC();
        return (List<Materia>) materiaDao.obtenerMateriasSinCargas(aux);
    }
    
    @Override
    public List<Materia> obtenerMateriasCargadas(Alumno alumno) {
        Long aux = alumno.getNC();
        return (List<Materia>) materiaDao.obtenerMateriasCargadas(aux);
    }

    @Override
    public void GuardarCarga(Carga carga) {
        cargaDao.save(carga);
    }
    
     @Override
    public Carga CargaF(Carga carga) {
        return cargaDao.findById(carga.getId()).orElse(null);
    }

    @Override
    public void EliminarCarga(Carga carga) {
         cargaDao.delete(carga);
    }

    

    
    
    
}
