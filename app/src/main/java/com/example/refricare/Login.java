package com.example.refricare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button registro = (Button)findViewById(R.id.registroLogin);
        Button btnLogin = (Button)findViewById(R.id.btnLogin);

        final EditText usuarioT = (EditText)findViewById(R.id.usuarioLogin);
        final EditText claveT = (EditText)findViewById(R.id.claveLogin);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(Login.this, Registro.class);
                Login.this.startActivity(registro);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usuario = usuarioT.getText().toString();
                final String clave = claveT.getText().toString();
                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if (ok == true){
                                String nombre = jsonRespuesta.getString("nombre");
                                Intent bienvenido = new Intent(Login.this, MainActivity.class);
                                bienvenido.putExtra("nombre",nombre);
                                Login.this.startActivity(bienvenido);

                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(Login.this);
                                alerta.setMessage("Error en Inicio de sesion")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.getMessage();
                        }
                    }
                };
                LoginRequest r = new LoginRequest(usuario,clave,respuesta);
                RequestQueue cola2 = Volley.newRequestQueue(Login.this);
                cola2.add(r);
            }
        });
    }
}