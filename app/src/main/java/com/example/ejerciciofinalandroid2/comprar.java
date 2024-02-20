package com.example.ejerciciofinalandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class comprar extends AppCompatActivity {
    TextView saldodispo;
    TextView monedaS;
    EditText cantidad;
    Button comprarM;

    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);
        saldodispo=findViewById(R.id.saldoDis);
        monedaS=findViewById(R.id.monedasele);
        comprarM=findViewById(R.id.buttonCompra2);
        volver=findViewById(R.id.buttonVolver);
        cantidad=findViewById(R.id.editTextText);
        String saldodisponible= String.valueOf(pPrincipal.saldo);
        saldodispo.setText(saldodisponible+"€");
        ListView listado = findViewById(R.id.listado);
        final String[] datos = new String[]{"Bitcoin","Ethereum","Dogecoin","Cardano"};
        comprarM.setOnClickListener(comprarCripto);
        volver.setOnClickListener(volverM);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String elemento =(String)datos[position];
                if (elemento=="Bitcoin"){
                    monedaS.setText("Bitcoin");
                } else if (elemento=="Ethereum") {
                    monedaS.setText("Ethereum");
                }
                else if (elemento=="Dogecoin") {
                    monedaS.setText("Dogecoin");
                }
                else if (elemento=="Cardano") {
                    monedaS.setText("Cardano");
                }
            }
        });
    }
    public View.OnClickListener comprarCripto = new View.OnClickListener() {
        public void onClick(View view) {
            String monedaCom=String.valueOf(monedaS.getText());
            String cantidadComS= cantidad.getText().toString();
            double cantidadCom= Double.parseDouble(cantidadComS);
            double pagar=0;
            FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(getApplicationContext());
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if(monedaCom=="Bitcoin"){
                pagar=cantidadCom*47848.8;
                if (pagar>pPrincipal.saldo){
                    CharSequence text = "saldo insuficiente";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(comprar.this, text, duration);
                    toast.show();
                }else{
                    db.execSQL("UPDATE CRIPTO SET CANTIDAD ="+cantidadCom+" where _id="+1);
                    db.close();
                    pPrincipal.saldo=pPrincipal.saldo-pagar;
                    String saldodisponible2= String.valueOf(pPrincipal.saldo);
                    saldodispo.setText(saldodisponible2+"€");
                }
            }else if(monedaCom=="Ethereum"){
                pagar=cantidadCom*2710.37;
                if (pagar>pPrincipal.saldo){
                    CharSequence text = "saldo insuficiente";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(comprar.this, text, duration);
                    toast.show();
                }else{
                    db.execSQL("UPDATE CRIPTO SET CANTIDAD ="+cantidadCom+" where _id="+2);
                    db.close();
                    pPrincipal.saldo=pPrincipal.saldo-pagar;
                    String saldodisponible2= String.valueOf(pPrincipal.saldo);
                    saldodispo.setText(saldodisponible2+"€");
                }
            }else if(monedaCom=="Dogecoin"){
                pagar=cantidadCom*0.080;
                if (pagar>pPrincipal.saldo){
                    CharSequence text = "saldo insuficiente";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(comprar.this, text, duration);
                    toast.show();
                }else{
                    db.execSQL("UPDATE CRIPTO SET CANTIDAD ="+cantidadCom+" where _id="+3);
                    db.close();
                    pPrincipal.saldo=pPrincipal.saldo-pagar;
                    String saldodisponible2= String.valueOf(pPrincipal.saldo);
                    saldodispo.setText(saldodisponible2+"€");
                }
            }else if(monedaCom=="Cardano"){
                pagar=cantidadCom*0.58;
                if (pagar>pPrincipal.saldo){
                    CharSequence text = "saldo insuficiente";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(comprar.this, text, duration);
                    toast.show();
                }else{
                    db.execSQL("UPDATE CRIPTO SET CANTIDAD ="+cantidadCom+" where _id="+4);
                    db.close();
                    pPrincipal.saldo=pPrincipal.saldo-pagar;
                    String saldodisponible2= String.valueOf(pPrincipal.saldo);
                    saldodispo.setText(saldodisponible2+"€");
                }
            }
        }
    };

    public View.OnClickListener volverM = new View.OnClickListener() {
        public void onClick(View view) {
            Intent ej= new Intent(view.getContext(), pPrincipal.class);
            startActivity(ej);
        }
    };
}