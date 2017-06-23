package com.example.s2pet.s2pet.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.s2pet.s2pet.R;

public class Contato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contato);
    }

    public void enviaSms(View v) {
        Cadastro_Dono objeto = new Cadastro_Dono();
        objeto.sms(v);

    }

    public void home(View v) {
        Intent home = new Intent(Contato.this, Home.class);
        startActivity(home);
    }
}
