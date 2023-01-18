package com.ProyectoFinal.TereTorres.Repository;

import com.ProyectoFinal.TereTorres.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepository extends JpaRepository<Proyectos, Integer>{
    
    public Optional<Proyectos> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
   
    
}
