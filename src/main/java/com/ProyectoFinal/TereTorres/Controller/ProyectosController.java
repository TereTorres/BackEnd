package com.ProyectoFinal.TereTorres.Controller;


import com.ProyectoFinal.TereTorres.Dto.DtoProyectos;
import com.ProyectoFinal.TereTorres.Entity.Proyectos;
import com.ProyectoFinal.TereTorres.Security.Controller.Mensaje;
import com.ProyectoFinal.TereTorres.Service.ImpProyectosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyectos")
@CrossOrigin(origins = "https://frontendtorres-59349.web.app/")
public class ProyectosController {
    
    @Autowired
    ImpProyectosService impProyectosService;
    
    
    @GetMapping("/listar")
    public ResponseEntity<List<Proyectos>> list(){
        
        List<Proyectos> list = impProyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyectos){
        
        if(StringUtils.isBlank(dtoProyectos.getTitulo()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impProyectosService.existsByTitulo(dtoProyectos.getTitulo()))
            return new ResponseEntity<>(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyecto = new Proyectos(dtoProyectos.getTitulo(), dtoProyectos.getDescripcion(), dtoProyectos.getImagen());
        impProyectosService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado con éxito"), HttpStatus.OK);
                
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!impProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
        Proyectos proyecto = impProyectosService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoProyectos){
        
        if(!impProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(impProyectosService.existsByTitulo(dtoProyectos.getTitulo()) && impProyectosService.getByTitulo(dtoProyectos.getTitulo()).get().getId_Proyecto() != id)
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoProyectos.getTitulo()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proy = impProyectosService.getOne(id).get();
        proy.setTitulo(dtoProyectos.getTitulo());
        proy.setDescripcion(dtoProyectos.getDescripcion());
        proy.setImagen(dtoProyectos.getImagen());
        
        impProyectosService.save(proy);
        return new ResponseEntity(new Mensaje("Proyecto actualizado exitosamente"), HttpStatus.OK);
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        
         if(!impProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
    
         impProyectosService.delete(id);
         
         return new ResponseEntity(new Mensaje("Proyecto eliminado exitosamente"), HttpStatus.OK);
         
    }
}
