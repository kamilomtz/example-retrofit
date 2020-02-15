package com.example.camilomtz.mascotas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pet {
    @SerializedName("nombre_del_propietario")
    @Expose
    private String nombre_del_propietario;
    private String nombre_mascota;
    private String raza,edad,sexo,especie,zona;

    public String getNombre_del_propietario() {
        return nombre_del_propietario;
    }

    public void setNombre_del_propietario(String nombre_del_propietario) {
        this.nombre_del_propietario = nombre_del_propietario;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
}
