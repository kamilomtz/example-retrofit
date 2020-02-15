package com.example.camilomtz.bibliotecas;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceDatCol {

    String JSONURL = "https://www.datos.gov.co/resource/";

    @GET("52vy-xsey.json")
    Call<String> getBibliotecas();
}
