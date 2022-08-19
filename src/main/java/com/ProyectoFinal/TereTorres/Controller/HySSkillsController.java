package com.ProyectoFinal.TereTorres.Controller;

import com.ProyectoFinal.TereTorres.Dto.DtoHySSkills;
import com.ProyectoFinal.TereTorres.Entity.HySSkills;
import com.ProyectoFinal.TereTorres.Security.Controller.Mensaje;
import com.ProyectoFinal.TereTorres.Service.ImpHySSkillsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("hys")
@CrossOrigin(origins = "http://localhost:4200")
public class HySSkillsController {
    
    @Autowired
    ImpHySSkillsService impHySSkillsService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<HySSkills>> list(){
        
        List<HySSkills> list = impHySSkillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoHySSkills dtoHySSkills){
        
        if(StringUtils.isBlank(dtoHySSkills.getTitle()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impHySSkillsService.existsByTitle(dtoHySSkills.getTitle()))
            return new ResponseEntity<>(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        HySSkills hySSkills = new HySSkills(dtoHySSkills.getPercent(), dtoHySSkills.getTitle());
        impHySSkillsService.save(hySSkills);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada con éxito"), HttpStatus.OK);
                
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detalle/{id}")
    public ResponseEntity<HySSkills> getById(@PathVariable("id") int id){
        if(!impHySSkillsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HySSkills hySSkills = impHySSkillsService.getOne(id).get();
        return new ResponseEntity(hySSkills, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHySSkills dtoHySSkills){
        
        if(!impHySSkillsService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(impHySSkillsService.existsByTitle(dtoHySSkills.getTitle()) && impHySSkillsService.getByTitle(dtoHySSkills.getTitle()).get().getId_Hys() != id)
            return new ResponseEntity(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoHySSkills.getTitle()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HySSkills hys = impHySSkillsService.getOne(id).get();
        hys.setTitle(dtoHySSkills.getTitle());
        hys.setPercent(dtoHySSkills.getPercent());
                
        impHySSkillsService.save(hys);
        return new ResponseEntity(new Mensaje("Habilidad actualizada exitosamente"), HttpStatus.OK);
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        
         if(!impHySSkillsService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
    
         impHySSkillsService.delete(id);
         
         return new ResponseEntity(new Mensaje("Habilidad eliminada exitosamente"), HttpStatus.OK);
         
    }
}
