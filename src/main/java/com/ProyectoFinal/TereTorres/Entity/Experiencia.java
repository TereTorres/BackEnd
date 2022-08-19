package com.ProyectoFinal.TereTorres.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Experiencia;
    
    private String nombreExp;
    private int anioIngreso;
    private int anioEgreso;
    private String cargoExp;
    private String descripcionExp; 

    public Experiencia() {
    }

    public Experiencia(String nombreExp, int anioIngreso, int anioEgreso, String cargoExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.anioIngreso = anioIngreso;
        this.anioEgreso = anioEgreso;
        this.cargoExp = cargoExp;
        this.descripcionExp = descripcionExp;
    }

    public int getId_Experiencia() {
        return id_Experiencia;
    }

    public void setId_Experiencia(int id_Experiencia) {
        this.id_Experiencia = id_Experiencia;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public int getAnioEgreso() {
        return anioEgreso;
    }

    public void setAnioEgreso(int anioEgreso) {
        this.anioEgreso = anioEgreso;
    }

    public String getCargoExp() {
        return cargoExp;
    }

    public void setCargoExp(String cargoExp) {
        this.cargoExp = cargoExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }
        
}
