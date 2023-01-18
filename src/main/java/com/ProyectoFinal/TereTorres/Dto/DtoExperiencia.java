package com.ProyectoFinal.TereTorres.Dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

    @NotBlank
    private String nombreExp;
    @NotBlank
    private String anioIngreso;
    @NotBlank
    private String anioEgreso;
    @NotBlank
    private String cargoExp;
    @NotBlank
    private String descripcionExp; 

    public DtoExperiencia() {
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(String anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String getAnioEgreso() {
        return anioEgreso;
    }

    public void setAnioEgreso(String anioEgreso) {
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

    public DtoExperiencia(String nombreExp, String anioIngreso, String anioEgreso, String cargoExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.anioIngreso = anioIngreso;
        this.anioEgreso = anioEgreso;
        this.cargoExp = cargoExp;
        this.descripcionExp = descripcionExp;
    }

}
