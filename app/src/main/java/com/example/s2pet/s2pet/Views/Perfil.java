package com.example.s2pet.s2pet.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.s2pet.s2pet.Models.Dono;
import com.example.s2pet.s2pet.R;
import com.example.s2pet.s2pet.Utils.Referencias;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Perfil extends AppCompatActivity {

    TextView nomeDono;
    TextView cpf;
    TextView email;
    TextView nomePet;
    EditText numCpf;
    List<Dono> donos;
    private FirebaseDatabase database; //TODO 6 - linha que cria uma instâcia de um obejto do tipo FirebaseDatabase
    private DatabaseReference reference; //TODO 7 - linha que cria uma instâcia de um obejto do tipo DatabaseReference


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

       /* Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String nomeD = bundle.getString("nomeDono");
        String cpfD = bundle.getString("cpf");
        String emailD = bundle.getString("email");
        String nomeP = bundle.getString("nomePet");*/

        nomeDono = (TextView) findViewById(R.id.txtNomeDono);
        cpf = (TextView) findViewById(R.id.txtCpf);
        email = (TextView) findViewById(R.id.txtEmail);
        nomePet = (TextView) findViewById(R.id.txtnomePet);
        numCpf = (EditText) findViewById(R.id.numCpfR);
        donos = new ArrayList<>();
        database =  FirebaseDatabase.getInstance();  //TODO 8 - esta linha atribui a variável a instâcia da base de dados do Firebase
        reference = database.getReference(Referencias.REFERENCIADONO);  //TODO 9 - esta linha atribui a variável uma referência("tabela") da base de dados
        /*nomeDono.setText(nomeD);
        cpf.setText(cpfD);
        email.setText(emailD);
        nomePet.setText(nomeP);*/
        recuperarDadosFirebase(); //TODO 21 - invocar o método recém criado.

    }

    public void recuperar(View view){ // TODO 22 - (OPCIONAL)Criar um método que será  responsável por passar os valores para outra tela

        for (Dono dono : donos){
            Log.i("LOG", "entrei no foreach : "+ dono.getNomeDono());
        }

        for (Dono d: donos) {

            if(d.getCpf().equals(numCpf.getText().toString())){
                Log.i("LOG", "entrei no IF");
                Intent intent = new Intent(this, Perfil.class);

                nomeDono.setText(d.getNomeDono());
                cpf.setText(d.getCpf());
                email.setText(d.getEmail());
                nomePet.setText(d.getNomePet());
            }

        }
    }

    private void recuperarDadosFirebase(){ //TODO 17 - Criar este método que é responsável por obter os dados do Firebase

        ValueEventListener valueEventListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                donos = new ArrayList<>();

                for (DataSnapshot d : dataSnapshot.getChildren()){ // TODO 18 - foreach que faz a iteração da lista obtida do Firebase
                    Dono dono = d.getValue(Dono.class); // TODO 19 - instância do objeto Dono que recebe um item da lista

                    donos.add(dono); // TODO 20 - adicionando o objeto numa lista
                    Log.i("LOG", "Nome dono "+ dono.getNomeDono());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        for (Dono d : donos){
            Log.i("LOG", "Foreach Listener "+ d.getNomeDono().toString());
        }

        reference.addValueEventListener(valueEventListener); // esta linha encerra a conexão
    }
}

