package com.ProyectoFinal.TereTorres.Controller;

import com.ProyectoFinal.TereTorres.Dto.DtoPersona;
import com.ProyectoFinal.TereTorres.Entity.Persona;
import com.ProyectoFinal.TereTorres.Security.Controller.Mensaje;
import com.ProyectoFinal.TereTorres.Service.ImpPersonaService;
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
@RequestMapping("personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    ImpPersonaService impPersonaService;
    
      
    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> list(){
        
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPersona){
        
        if(StringUtils.isBlank(dtoPersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impPersonaService.existsByNombre(dtoPersona.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(dtoPersona.getNombre(), dtoPersona.getImg(), dtoPersona.getAcerca_de());
        impPersonaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona agregada con éxito"), HttpStatus.OK);
                
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!impPersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
        Persona per = impPersonaService.getOne(id).get();
        return new ResponseEntity(per, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona){
        
        if(!impPersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(impPersonaService.existsByNombre(dtoPersona.getNombre()) && impPersonaService.getByNombre(dtoPersona.getNombre()).get().getId_Persona() != id)
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoPersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona per = impPersonaService.getOne(id).get();
        per.setNombre(dtoPersona.getNombre());
        per.setImg(dtoPersona.getImg());
        per.setAcerca_de(dtoPersona.getAcerca_de());
        
        impPersonaService.save(per);
        return new ResponseEntity(new Mensaje("Persona actualizada exitosamente"), HttpStatus.OK);
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        
         if(!impPersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
    
         impPersonaService.delete(id);
         
         return new ResponseEntity(new Mensaje("Persona eliminada exitosamente"), HttpStatus.OK);
         
    }
}
