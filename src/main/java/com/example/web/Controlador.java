package com.example.web;

//import com.example.domain.Alumno;
import com.example.domain.Alumno;
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
        
        
        log.info("Se esta ejecutando el proyecto con modelo");
        model.addAttribute("alumnos", alumnos);

        return "indice";
    }
    
    @GetMapping("/showAlta")
    public String alta(Alumno alumno) {
        return "alta";
    }
    
    @PostMapping("/guardar")
    public String GuardarAlumno(Alumno alumno) {
        modelo.GuardarAlumno(alumno);
        return "redirect:/";
    }
    
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", e.getMessage());
        return modelAndView;
    }
}
