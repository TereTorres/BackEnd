package com.ProyectoFinal.TereTorres.Service;

import com.ProyectoFinal.TereTorres.Entity.HySSkills;
import com.ProyectoFinal.TereTorres.Repository.IHySSkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpHySSkillsService {
    
    @Autowired
    IHySSkillsRepository iHySSkillsRepository;
    
    
    public List<HySSkills> list(){
        
        return iHySSkillsRepository.findAll();
    }
    
    public Optional<HySSkills> getOne(int id){
        
        return iHySSkillsRepository.findById(id);
    }
    
    public Optional<HySSkills> getByTitle(String title){
        
        return iHySSkillsRepository.findByTitle(title);
    }
    
    public void save(HySSkills hys){
        
        iHySSkillsRepository.save(hys);
    }
    
    public void delete(int id){
        iHySSkillsRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        
        return iHySSkillsRepository.existsById(id);
    }
    
    public boolean existsByTitle(String title){
        
        return iHySSkillsRepository.existsByTitle(title);
    }
}
