package com.example.servicio;

import com.example.domain.Alumno;
import com.example.domain.Carga;
import java.util.List;

public interface CargaServicios {
    
    public List<Carga> ObtenerCarga(Alumno alumno);
    
    public void GuardarCarga(Carga carga);
    
    public Carga CargaF(Carga carga);
    
    public void EliminarCarga(Carga carga);
    
    
    
    
}
