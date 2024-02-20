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

        FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry._ID,"1");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME, "Bitcoin");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_VALOR, "47848.8");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CANTIDAD, "0");
        long newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
        ContentValues values2 = new ContentValues();
        values2.put(FeedReaderContract.FeedEntry._ID,"2");
        values2.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME, "Ethereum");
        values2.put(FeedReaderContract.FeedEntry.COLUMN_NAME_VALOR, "2710.37");
        values2.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CANTIDAD, "0");
        long newRowId2 = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
        ContentValues values3 = new ContentValues();
        values.put(FeedReaderContract.FeedEntry._ID,"3");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME, "Dogecoin");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_VALOR, "0.080");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CANTIDAD, "0");
        long newRowId3 = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
        ContentValues values4 = new ContentValues();
        values.put(FeedReaderContract.FeedEntry._ID,"4");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME, "Cardano");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_VALOR, "0.58");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CANTIDAD, "0");
        long newRowId4 = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
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
            Intent ej= new Intent(v.getContext(), comprar.class);
            startActivity(ej);
        }
        else if (img==findViewById(R.id.imageSalir)) {
            Intent ej= new Intent(v.getContext(), comprar.class);
            startActivity(ej);
        }
    }
}