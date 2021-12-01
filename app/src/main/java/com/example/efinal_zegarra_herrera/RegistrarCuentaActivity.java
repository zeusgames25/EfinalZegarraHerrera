package com.example.efinal_zegarra_herrera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class RegistrarCuentaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);

        EditText ed = findViewById(R.id.edNombre);
        String nombre = ed.getText().toString();

        Intent intent = new Intent(getApplicationContext(),RegistrarCuentaActivity.class);
        intent.putExtra("nombre",nombre);


    }
}