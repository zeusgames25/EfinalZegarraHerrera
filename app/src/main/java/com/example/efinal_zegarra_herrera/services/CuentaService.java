package com.example.efinal_zegarra_herrera.services;

import com.example.efinal_zegarra_herrera.Clases.Cuenta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CuentaService {

    @GET("cuentas")
    Call<List<Cuenta>> all();

    @POST("users")
    Call<Cuenta> create(@Body Cuenta cuenta);
}
