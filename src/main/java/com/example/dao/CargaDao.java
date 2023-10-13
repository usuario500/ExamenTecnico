package com.example.dao;

import com.example.domain.Carga;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CargaDao extends CrudRepository<Carga, Long>{
    @Query("SELECT c FROM Carga c WHERE c.NC = :nc")
    List<Carga> buscarCarga(@Param("nc") int nc);
}
