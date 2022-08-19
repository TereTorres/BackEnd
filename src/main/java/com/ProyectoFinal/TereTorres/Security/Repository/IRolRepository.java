package com.ProyectoFinal.TereTorres.Security.Repository;

import com.ProyectoFinal.TereTorres.Security.Entity.Rol;
import com.ProyectoFinal.TereTorres.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
