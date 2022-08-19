package com.ProyectoFinal.TereTorres.Dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

    @NotBlank
    private String nombreExp;
    @NotBlank
    private int anioIngreso;
    @NotBlank
    private int anioEgreso;
    @NotBlank
    private String cargoExp;
    @NotBlank
    private String descripcionExp; 

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExp, int anioIngreso, int anioEgreso, String cargoExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.anioIngreso = anioIngreso;
        this.anioEgreso = anioEgreso;
        this.cargoExp = cargoExp;
        this.descripcionExp = descripcionExp;
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
