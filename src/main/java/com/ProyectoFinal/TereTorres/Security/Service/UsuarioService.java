package com.ProyectoFinal.TereTorres.Security.Service;

import com.ProyectoFinal.TereTorres.Security.Entity.Usuario;
import com.ProyectoFinal.TereTorres.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    IUsuarioRepository iUsuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
         return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        
        return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iUsuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }
    
    public boolean existsById(int id){
        return iUsuarioRepository.existsById(id);
    }
    
    public void delete(int id){
        iUsuarioRepository.deleteById(id);
    }
}
