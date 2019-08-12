package com.example.refricare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Bienvenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        final TextView mensaje = (TextView)findViewById(R.id.msn);
        Intent i = this.getIntent();
        String nombre = i.getStringExtra("nombre");
        mensaje.setText(mensaje.getText()+""+nombre);
    }
}

