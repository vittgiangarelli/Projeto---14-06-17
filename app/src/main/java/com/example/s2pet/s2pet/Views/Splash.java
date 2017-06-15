package com.example.s2pet.s2pet.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.os.Handler;


import com.example.s2pet.s2pet.R;

/**
 * Created by aluno on 05/05/2017.
 */

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent home = new Intent(Splash.this, Cadastro_Dono.class);
                startActivity(home);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
