package com.example.camilomtz.mascotas;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    String JSONURL = "https://www.datos.gov.co/resource/";
    @RequiresApi(api = Build.VERSION_CODES.N)
    @GET("/resource/q2pa-tbcs.json")
        //Call<List<Pet>> getPet();
    Call<String> getPet();


//    @GET("52vy-xsey.json")
  //  Call<String> getBibliotecas();
}
