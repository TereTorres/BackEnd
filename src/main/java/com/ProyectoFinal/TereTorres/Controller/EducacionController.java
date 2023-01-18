package com.ProyectoFinal.TereTorres.Controller;

import com.ProyectoFinal.TereTorres.Dto.DtoEducacion;
import com.ProyectoFinal.TereTorres.Entity.Educacion;
import com.ProyectoFinal.TereTorres.Security.Controller.Mensaje;
import com.ProyectoFinal.TereTorres.Service.ImpEducacionService;
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
@RequestMapping("educacion")
@CrossOrigin(origins = "https://frontendtorres.web.app/")
public class EducacionController {
    
    @Autowired
    ImpEducacionService impEducacionService;
    
   
    @GetMapping("/listar")
    public ResponseEntity<List<Educacion>> list(){
        
        List<Educacion> list = impEducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion){
        
        if(StringUtils.isBlank(dtoEducacion.getNivel()))
            return new ResponseEntity(new Mensaje("El nivel es obligatorio"),HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoEducacion.getNivel(), dtoEducacion.getInstitucion(), dtoEducacion.getTitulo());
        impEducacionService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Nivel agregado con éxito"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion experiencia = impEducacionService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion){
        
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje(), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEducacion.getNivel()))
            return new ResponseEntity(new Mensaje("El nivel es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion edu = impEducacionService.getOne(id).get();
        edu.setNivel(dtoEducacion.getNivel());
        edu.setInstitucion(dtoEducacion.getInstitucion());
        edu.setTitulo(dtoEducacion.getTitulo());
        
        impEducacionService.save(edu);
        return new ResponseEntity(new Mensaje("Nivel actualizado exitosamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        impEducacionService.delete(id);
        
        return new ResponseEntity(new Mensaje("Nivel eliminado exitosamente"), HttpStatus.OK);
    }
}
