package com.ProyectoFinal.TereTorres.Controller;

import com.ProyectoFinal.TereTorres.Dto.DtoExperiencia;
import com.ProyectoFinal.TereTorres.Entity.Experiencia;
import com.ProyectoFinal.TereTorres.Security.Controller.Mensaje;
import com.ProyectoFinal.TereTorres.Service.ImpExperienciaService;
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
@RequestMapping("explab")
@CrossOrigin(origins = "https://frontendtorres-59349.web.app/")
public class ExperienciaController {
    
    @Autowired
    ImpExperienciaService impExperienciaService;
    
   
    @GetMapping("/listar")
    public ResponseEntity<List<Experiencia>> list(){
        
        List<Experiencia> list = impExperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExperiencia){
        
        if(StringUtils.isBlank(dtoExperiencia.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impExperienciaService.existsByNombreExp(dtoExperiencia.getNombreExp()))
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoExperiencia.getNombreExp(), dtoExperiencia.getAnioIngreso(), dtoExperiencia.getAnioEgreso(),
                dtoExperiencia.getCargoExp(), dtoExperiencia.getDescripcionExp());
        impExperienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada con éxito"), HttpStatus.OK);
                
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = impExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia){
        
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(impExperienciaService.existsByNombreExp(dtoExperiencia.getNombreExp()) && impExperienciaService.getByNombreExp(dtoExperiencia.getNombreExp()).get().getId_Experiencia() != id)
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoExperiencia.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia exp = impExperienciaService.getOne(id).get();
        exp.setNombreExp(dtoExperiencia.getNombreExp());
        exp.setAnioIngreso(dtoExperiencia.getAnioIngreso());
        exp.setAnioEgreso(dtoExperiencia.getAnioEgreso());
        exp.setCargoExp(dtoExperiencia.getCargoExp());
        exp.setDescripcionExp(dtoExperiencia.getDescripcionExp());
        
        impExperienciaService.save(exp);
        return new ResponseEntity(new Mensaje("Experiencia actualizada exitosamente"), HttpStatus.OK);
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        
         if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
    
         impExperienciaService.delete(id);
         
         return new ResponseEntity(new Mensaje("Experiencia eliminada exitosamente"), HttpStatus.OK);
         
    }
}
