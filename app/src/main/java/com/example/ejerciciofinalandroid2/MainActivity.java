package com.example.ejerciciofinalandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usuario;
    EditText contraseña;
    Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.editUser);
        contraseña = findViewById(R.id.editPassw);
        iniciar=findViewById(R.id.inicio);
        iniciar.setOnClickListener(iniciado);

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

        db.execSQL("UPDATE CRIPTO SET CANTIDAD=0 WHERE _id=1");
        db.execSQL("UPDATE CRIPTO SET CANTIDAD=0 WHERE _id=2");
        db.execSQL("UPDATE CRIPTO SET CANTIDAD=0 WHERE _id=3");
        db.execSQL("UPDATE CRIPTO SET CANTIDAD=0 WHERE _id=4");


    }
    public View.OnClickListener iniciado = new View.OnClickListener() {
        public void onClick(View view) {
            String usuarioIng=usuario.getText().toString();
            String contraIng=contraseña.getText().toString();
            if(usuarioIng.equals("ADMIN")&&contraIng.equals("1234")){
                Intent ej= new Intent(view.getContext(), pPrincipal.class);
                startActivity(ej);
            }else{
                CharSequence text = "USUARIO/CONTRASEÑA INCORRECTOS";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(MainActivity.this, text, duration);
                toast.show();
            }
        }
    };
}

