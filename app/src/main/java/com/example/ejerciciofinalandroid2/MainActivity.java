package com.example.ejerciciofinalandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

