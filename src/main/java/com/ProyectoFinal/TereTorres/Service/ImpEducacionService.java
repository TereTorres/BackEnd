package com.ProyectoFinal.TereTorres.Service;

import com.ProyectoFinal.TereTorres.Entity.Educacion;
import com.ProyectoFinal.TereTorres.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService {
    
    @Autowired
    IEducacionRepository iEducacionRepository;
    
    public List<Educacion> list(){
        
        return iEducacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        
        return iEducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByNivel(String nivel){
        
        return iEducacionRepository.findByNivel(nivel);
    }
    
    public void save(Educacion edu) {
        
        iEducacionRepository.save(edu);
    }
    
    public void delete(int id){
        
        iEducacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        
        return iEducacionRepository.existsById(id);
    }
    
    public boolean existsByNivel(String nivel){
        
        return iEducacionRepository.existsByNivel(nivel);
    }
}
