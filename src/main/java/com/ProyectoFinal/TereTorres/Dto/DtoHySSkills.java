package com.ProyectoFinal.TereTorres.Dto;

import javax.validation.constraints.NotBlank;

public class DtoHySSkills {
    
    @NotBlank
    private int percent;
    
    @NotBlank
    private String title;

    public DtoHySSkills() {
    }

    public DtoHySSkills(int percent, String title) {
        this.percent = percent;
        this.title = title;
    }

    public int getPercent() {
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
