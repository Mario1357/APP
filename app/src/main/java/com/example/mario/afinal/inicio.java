package com.example.mario.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class inicio extends AppCompatActivity {

    Button mu, parabolico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        mu = (Button) findViewById(R.id.mua);

        mu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mu = new Intent(inicio.this, MainActivity.class);
                startActivity(mu);
            }
        });

        parabolico = (Button) findViewById(R.id.parabola);

        parabolico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent parabolico = new Intent(inicio.this, parabolico.class);
                startActivity(parabolico);
            }
        });
    }
}
