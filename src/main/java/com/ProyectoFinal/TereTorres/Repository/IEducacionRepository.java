package com.ProyectoFinal.TereTorres.Repository;

import com.ProyectoFinal.TereTorres.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer>{
    
    public Optional<Educacion> findByNivel(String nivel);
    public boolean existsByNivel(String nivel);
}
