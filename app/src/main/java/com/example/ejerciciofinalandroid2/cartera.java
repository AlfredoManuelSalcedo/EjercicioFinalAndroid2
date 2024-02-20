package com.example.ejerciciofinalandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class cartera extends AppCompatActivity {
    TextView Bit;
    TextView Eth;
    TextView Doge;
    TextView Carda;
    EditText Agrego;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartera);
        Bit=findViewById(R.id.bitcoinMues);
        Eth=findViewById(R.id.ethereumMues);
        Doge=findViewById(R.id.dogecoinMues);
        Carda=findViewById(R.id.bitcoinCardano);
        Bit.setText(String.valueOf(comprar.bitcoinC));
        Eth.setText(String.valueOf(comprar.ethereumC));
        Doge.setText(String.valueOf(comprar.dogecoinC));
        Carda.setText(String.valueOf(comprar.cardanoC));
        Agrego=findViewById(R.id.editTextText2);

        agregar=findViewById(R.id.agrego);
        agregar.setOnClickListener(agregado);
    }
    public View.OnClickListener agregado = new View.OnClickListener() {
        public void onClick(View view) {
            String sagregar=String.valueOf(Agrego.getText());
            Double nagregar=Double.parseDouble(sagregar);
            pPrincipal.saldo=pPrincipal.saldo+nagregar;
        }
    };
}