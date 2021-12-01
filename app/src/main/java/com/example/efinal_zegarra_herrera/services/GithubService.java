package com.example.efinal_zegarra_herrera.services;

import com.example.efinal_zegarra_herrera.Clases.Cuenta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubService {
    @GET("n00038107/accounts")
    Call<List<Cuenta>> allRepos();
}
