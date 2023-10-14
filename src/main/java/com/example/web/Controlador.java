package com.example.web;

//import com.example.domain.Alumno;
import com.example.domain.Alumno;
import com.example.domain.Carga;
import com.example.domain.Materia;
import com.example.servicio.Modelo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
//import com.example.dao.AlumnoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class Controlador {

   @Autowired
    private Modelo modelo;
    //private AlumnoDao alumnoDao;
    

    @GetMapping("/")
    public String comienso(Model model) {

        List<Alumno> alumnos = modelo.ObtenerAlumnos();
        List<Materia> materias = modelo.ObtenerMaterias();
        
        log.info("Se esta ejecutando el proyecto con modelo");
        model.addAttribute("alumnos", alumnos);
        model.addAttribute("materias", materias);

        return "indice";
    }
    
    //Metodos para Alumno
    @GetMapping("/showAlta")
    public String alta(Alumno alumno) {
        return "alta";
    }
    
    @GetMapping("/showModificar/{NC}")
    public String modificar(Alumno alumno, Model model) {
        log.info("aeeeeeeeee");
        alumno = modelo.AlumnoF(alumno);
        model.addAttribute("alumno", alumno);
        return "alta";
    }
    
    @GetMapping("/eliminar/{NC}")
    public String eliminar(Alumno alumno) {
        log.info("juejuejue");
        alumno = modelo.AlumnoF(alumno);
        alumno.setActivo(0);
        modelo.GuardarAlumno(alumno);
        return "redirect:/";
    }
    
    @PostMapping("/guardar")
    public String GuardarAlumno(Alumno alumno) {
        alumno.setActivo(1);
        modelo.GuardarAlumno(alumno);
        return "redirect:/";
    }
    
    //Metodos para materias
    @GetMapping("/showMateria")
    public String añadirMateria(Materia materia) {
        return "materia";
    }
    
    @GetMapping("/showModificarMateria/{id}")
    public String modificarMateria(Materia materia, Model model) {
        log.info("aeeeeeeeee");
        materia = modelo.MateriaF(materia);
        model.addAttribute("materia", materia);
        return "materia";
    }
    
    @GetMapping("/eliminarMateria/{id}")
    public String eliminarMateria(Materia materia) {
        log.info("juejuejue");
        materia = modelo.MateriaF(materia);
        materia.setActivo(0);
        modelo.GuardarMateria(materia);
        return "redirect:/";
    }
    
    @PostMapping("/guardarMateria")
    public String GuardarMateria(Materia materia) {
        materia.setActivo(1);
        modelo.GuardarMateria(materia);
        return "redirect:/";
    }
    
    //Metodos para Carga
    
    @GetMapping("/showCarga/{NC}")
    public String MostrarCarga(Alumno alumno, Model model) {

        List<Carga> cargas = modelo.ObtenerCarga(alumno);
        List<Materia> materias = modelo.obtenerMateriasCargadas(alumno);
        log.info("Se intensa obtener la carga");
        log.info("Contenido de miObjeto: {}", materias);
        model.addAttribute("cargas", cargas);
        model.addAttribute("materias", materias);

        return "carga";
    }
    
    @GetMapping("/showCargar/{NC}")
    public String ObtenerMateriasCarga(Alumno alumno, Carga carga, Model model) {

        carga.setId(null);
        List<Materia> materias = modelo.ObtenerMateriasCarga(alumno);
        alumno = modelo.AlumnoF(alumno);
        log.info("Se intensa obtener la carga");
        log.info("Contenido de miObjeto: {}", materias);
        model.addAttribute("materias", materias);
        model.addAttribute("alumno", alumno);
        model.addAttribute("carga", carga);
        return "cargar";
    }
    
    @GetMapping("/showModificarCarga/{id}")
    public String modificarCarga(Alumno alumno, Carga carga, Model model) {
        
        carga = modelo.CargaF(carga);
        int aux = carga.getNC();
        Long Aux = Long.valueOf(aux);
        alumno.setNC(Aux);
        List<Materia> materias = modelo.ObtenerMateriasCarga(alumno);
        alumno = modelo.AlumnoF(alumno);
        log.info("Se intensa obtener la carga");
        log.info("Contenido de miObjeto: {}", materias);
        model.addAttribute("materias", materias);
        model.addAttribute("alumno", alumno);
        model.addAttribute("carga", carga);
        return "cargar";
    }
    
    @GetMapping("/eliminarCarga/{id}")
    public String EliminarCarga(Carga carga, Model model) {
        carga = modelo.CargaF(carga);
        log.info("Contenido de miObjeto: {}", carga);
        String ruta = "/showCarga/" + carga.getNC();
        modelo.EliminarCarga(carga);
        return "redirect:" + ruta;
    }
    
    @PostMapping("/guardarCarga")
    public String GuardarMateriaCargada(Carga carga) {
        log.info("Contenido de miObjeto: {}", carga);
        modelo.GuardarCarga(carga);
        return "redirect:/showCargar/" + carga.getNC();
    }
    
    
    //error
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", e.getMessage());
        return modelAndView;
    }
}
