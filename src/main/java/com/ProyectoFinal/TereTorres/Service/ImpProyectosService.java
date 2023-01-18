package com.ProyectoFinal.TereTorres.Service;

import com.ProyectoFinal.TereTorres.Entity.Proyectos;
import com.ProyectoFinal.TereTorres.Repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectosService {
    
    @Autowired
    IProyectosRepository iProyectosRepository;
    
    
    public List<Proyectos> list(){
        
        return iProyectosRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        
        return iProyectosRepository.findById(id);
    }
    
    public Optional<Proyectos> getByTitulo(String titulo){
        
        return iProyectosRepository.findByTitulo(titulo);
    }
    
    public void save(Proyectos proy){
        
        iProyectosRepository.save(proy);
    }
    
    public void delete(int id){
        iProyectosRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        
        return iProyectosRepository.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        
        return iProyectosRepository.existsByTitulo(titulo);
    }
}
