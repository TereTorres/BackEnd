package com.ProyectoFinal.TereTorres.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Educacion;
    
    private String nivel;
    private String institucion;
    private String titulo;

    public Educacion() {
    }

    public Educacion(String nivel, String institucion, String titulo) {
        this.nivel = nivel;
        this.institucion = institucion;
        this.titulo = titulo;
    }

    public int getId_Educacion() {
        return id_Educacion;
    }

    public void setId_Educacion(int id_Educacion) {
        this.id_Educacion = id_Educacion;
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
