package com.ProyectoFinal.TereTorres.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String img;
    @NotBlank
    private String acerca_de;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String img, String acerca_de) {
        this.nombre = nombre;
        this.img = img;
        this.acerca_de = acerca_de;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAcerca_de() {
        return acerca_de;
    }

    public void setAcerca_de(String acerca_de) {
        this.acerca_de = acerca_de;
    }
    
    
}
