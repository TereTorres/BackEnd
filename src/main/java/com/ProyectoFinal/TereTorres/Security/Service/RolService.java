package com.ProyectoFinal.TereTorres.Security.Service;

import com.ProyectoFinal.TereTorres.Security.Entity.Rol;
import com.ProyectoFinal.TereTorres.Security.Enums.RolNombre;
import com.ProyectoFinal.TereTorres.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RolService {
 
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public Optional<Rol> getById(int id){
        
        return iRolRepository.findById(id);
    }
    
    
    public void save(Rol rol){
        
        iRolRepository.save(rol);
    }
}
