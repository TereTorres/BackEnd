package com.ProyectoFinal.TereTorres.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HySSkills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Hys;
    
    private int percent;
    private String title;

    public HySSkills() {
    }

    public HySSkills(int percent, String title) {
        this.percent = percent;
        this.title = title;
    }

    public int getId_Hys() {
        return id_Hys;
    }

    public void setId_Hys(int id_Hys) {
        this.id_Hys = id_Hys;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
