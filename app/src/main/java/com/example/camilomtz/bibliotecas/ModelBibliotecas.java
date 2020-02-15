package com.example.camilomtz.bibliotecas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelBibliotecas {

    @SerializedName("departamento")
    @Expose
    private String departamento;
    @SerializedName("municipio")
    @Expose
    private String municipio;
    @SerializedName("nombre_de_la_biblioteca")
    @Expose
    private String nombre;
    @SerializedName("direcci_n_de_la_biblioteca")
    @Expose
    private String direccion;
    @SerializedName("barrio")
    @Expose
    private String barrio;
    @SerializedName("tel_fonos_de_contacto")
    @Expose
    private String telefono;

    public String getDepartamento() {
        return departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
