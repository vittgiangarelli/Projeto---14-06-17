package com.example.s2pet.s2pet.Views;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.s2pet.s2pet.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private FirebaseDatabase database; //TODO 6 - linha que cria uma instâcia de um obejto do tipo FirebaseDatabase
    private DatabaseReference reference; //TODO 7 - linha que cria uma instâcia de um obejto do tipo DatabaseReference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulateral);

        database = FirebaseDatabase.getInstance();  //TODO 8 - esta linha atribui a variável a instâcia da base de dados do Firebase
        reference = database.getReference("Donos");  //TODO 9 - esta linha atribui a variável uma referência("tabela") da base de dados


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.login) {

                Intent intent = new Intent(this, MenuPrincipal.class);
                startActivity(intent);

            } /*else if (id == R.id.nav_tela_inicial) {

                Toast.makeText(MainActivity.this, "Teste do menu", Toast.LENGTH_SHORT).show();
                // Handle the camera action

            } else if (id == R.id._login) {

                Intent intent = new Intent(MainActivity.this, PosLogin.class);
                startActivity(intent);

            } else if (id == R.id.nav_cadastro_pet) {

                Intent intent = new Intent(MainActivity.this, CadastroPet.class);
                startActivity(intent);


            } else if (id == R.id.nav_tela_vacina) {

                Intent intent = new Intent(MainActivity.this, Vacina.class);
                startActivity(intent);

            } else if (id == R.id.nav_cadastro_dono) {

                Intent intent = new Intent(MainActivity.this, CadastroDono.class);
                startActivity(intent);
            }*/

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_lateral, menu);
            return true;
        }
    }

