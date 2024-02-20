package com.example.ejerciciofinalandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class pPrincipal extends AppCompatActivity implements View.OnClickListener {
    ImageView compra;
    ImageView venta;
    ImageView cartera;
    ImageView salir;
    public static double saldo = 50000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pprincipal);
        compra = findViewById(R.id.imageCompra);
        venta = findViewById(R.id.imageVender);
        cartera = findViewById(R.id.imageCartera);
        salir= findViewById(R.id.imageSalir);
        compra.setOnClickListener(this);
        venta.setOnClickListener(this);
        cartera.setOnClickListener(this);
        salir.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        ImageView img = findViewById(v.getId());
        if(img==findViewById(R.id.imageCompra)){
            Intent ej= new Intent(v.getContext(), comprar.class);
            startActivity(ej);
        }
        else if (img==findViewById(R.id.imageVender)) {
            Intent ej= new Intent(v.getContext(), vender.class);
            startActivity(ej);
        }
        else if (img==findViewById(R.id.imageCartera)) {
            Intent ej= new Intent(v.getContext(), cartera.class);
            startActivity(ej);
        }
        else if (img==findViewById(R.id.imageSalir)) {
            Intent ej= new Intent(v.getContext(), comprar.class);
            startActivity(ej);
        }
    }
}