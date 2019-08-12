package com.example.refricare;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class pantalla_carga extends AppCompatActivity {

    private final int DURACION_SPLASH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pantalla_carga);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(pantalla_carga.this, Login.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}