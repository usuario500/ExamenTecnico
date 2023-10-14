package com.example.dao;

import com.example.domain.Materia;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MateriaDao extends CrudRepository<Materia, Long> {

    @Query("SELECT m FROM Materia m LEFT JOIN Carga c ON m.id = c.id_materia AND c.NC = :nc WHERE c.id_materia IS NULL AND m.activo = 1")
    List<Materia> obtenerMateriasSinCargas(@Param("nc") Long nc);
    
    
    @Query("SELECT m FROM Materia m LEFT JOIN Carga c ON m.id = c.id_materia AND c.NC = :nc WHERE c.id_materia IS NOT NULL AND m.activo = 1")
    List<Materia> obtenerMateriasCargadas(@Param("nc") Long nc);
}
