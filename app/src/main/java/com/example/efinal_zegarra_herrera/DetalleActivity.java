package com.example.efinal_zegarra_herrera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.efinal_zegarra_herrera.Clases.Cuenta;
import com.example.efinal_zegarra_herrera.adapters.RepositorioAdapter;
import com.example.efinal_zegarra_herrera.services.GithubService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        //inten para recicbir valor ya no se crea solo se declara
//        Intent intent = getIntent();
//        String valor = intent.getStringExtra("valor");//recibiendo valor de main

//        TextView tv = findViewById(R.id.tvMensaje);
//        tv.setText(valor);

        RecyclerView rv = findViewById(R.id.rvLista);
        //confguraciones que siempre van recicler view
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

   //    llamamos api retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);
        service.allRepos().enqueue(new Callback<List<Cuenta>>() {
            @Override
            public void onResponse(Call<List<Cuenta>> call, Response<List<Cuenta>> response) {
                Log.i("MAIN_APP", "Conectado al api");
                Log.i("MAIN_APP", new Gson().toJson(response.body()));

                RepositorioAdapter adapter = new RepositorioAdapter(response.body());

                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Cuenta>> call, Throwable t) {
                Log.i("MAIN_APP", "No hubo comunicacion en el servidor");


            }
        });

      //  creo lista para enviar mis datos
//        List<Repositorio> datos = Arrays.asList(new Repositorio(1,"repo1"),new Repositorio(2,"repo2"));
//        RepositorioAdapter adapter = new RepositorioAdapter(datos);
//
//        rv.setAdapter(adapter);
    }
}