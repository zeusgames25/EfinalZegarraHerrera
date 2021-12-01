package com.example.efinal_zegarra_herrera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.efinal_zegarra_herrera.Clases.Cuenta;
import com.example.efinal_zegarra_herrera.services.CuentaService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("MAIN_APP_CICLO DE VIDA","oncreate");

        Button btMos = findViewById(R.id.btnMostrar);
        Button btsincro = findViewById(R.id.btnSincronizar);
        Button btReg = findViewById(R.id.btnRegistrar);

        btsincro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://zeus2608.free.beeceptor.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
//
                CuentaService service = retrofit.create(CuentaService.class);

                Intent intent = getIntent();
                String nombre = intent.getStringExtra("nombre");


                Cuenta cuenta = new Cuenta();
                cuenta.setNombre(nombre);
                cuenta.setFechacreacion("2021-01-01");
                cuenta.setSucursal1("-7.1515848,-78.5146089");
                cuenta.setSucursal2("-7.1515848,-78.5146089");
                cuenta.setSucursal3("-7.1515848,-78.5146089");
                cuenta.setImagen("https://d500.epimg.net/cincodias/imagenes/2019/02/08/mercados/1549629352_971073_1549644601_noticia_normal.jpg");

                service.create(cuenta).enqueue(new Callback<Cuenta>() {
                    @Override
                    public void onResponse(Call<Cuenta> call, Response<Cuenta> response) {
                        new Gson().toJson(response.body());
                    }

                    @Override
                    public void onFailure(Call<Cuenta> call, Throwable t) {
                        Log.i("MAIN_APP", "no se puede establecer conexion");
                    }
                });

            }
        });

        btMos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//

                Intent intent  = new Intent(getApplicationContext(),DetalleActivity.class);
                startActivity(intent);


            }
        });

        btReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//
                //  pasar a otra actividad
                Intent intent  = new Intent(getApplicationContext(),RegistrarCuentaActivity.class);
                // intent.putExtra("valor",valor); // guardando el valor en intent para pasar a otra actividad
                startActivity(intent);


            }
        });
    }

}