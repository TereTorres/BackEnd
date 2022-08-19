package com.ProyectoFinal.TereTorres.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {
    
    @NotBlank
    private String nivel;
    @NotBlank
    private String institucion;
    @NotBlank
    private String titulo;

    public DtoEducacion() {
    }

    public DtoEducacion(String nivel, String institucion, String titulo) {
        this.nivel = nivel;
        this.institucion = institucion;
        this.titulo = titulo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
