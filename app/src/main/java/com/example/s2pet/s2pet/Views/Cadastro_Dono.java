package com.example.s2pet.s2pet.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.s2pet.s2pet.Models.Dono;
import com.example.s2pet.s2pet.R;
import com.example.s2pet.s2pet.Utils.Referencias;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cadastro_Dono extends AppCompatActivity {

    private EditText nomeDono;
    private EditText cpf;
    private EditText email;
    private EditText nomePet;
    private EditText vacina;
    private TextView lista;
    private List<String> listaVacinas;
    private FirebaseDatabase database; //TODO 6 - linha que cria uma instâcia de um obejto do tipo FirebaseDatabase
    private DatabaseReference reference; //TODO 7 - linha que cria uma instâcia de um obejto do tipo DatabaseReference
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrodono);





        nomeDono = (EditText) findViewById(R.id.nomeDono);
        cpf = (EditText) findViewById(R.id.NumCpf);
        email = (EditText) findViewById(R.id.EndEmail);
        nomePet = (EditText) findViewById(R.id.nomePet);
        vacina = (EditText)findViewById(R.id.vacina);
        lista = (TextView) findViewById(R.id.listaVacinas);
        btn = (Button) findViewById(R.id.button3);
        listaVacinas = new ArrayList<>();
        database =  FirebaseDatabase.getInstance();  //TODO 8 - esta linha atribui a variável a instâcia da base de dados do Firebase
        reference = database.getReference(Referencias.REFERENCIADONO);  //TODO 9 - esta linha atribui a variável uma referência("tabela") da base de dados

    }

    public void salvarDados(View view){

        Dono dono = new Dono(cpf.getText().toString(), nomeDono.getText().toString(),email.getText().toString(), nomePet.getText().toString(), listaVacinas); // TODO 12 - instânciar um objeto Dono e passar os valores que serão salvos pelo construtor

        Map<String, Object> valoresDono = dono.mapaDeValores(); //TODO 13 - atribuir o mapa de valores da classe Dono a variavel
        Map<String, Object> enviarValores = new HashMap<>(); //TODO 14 - criar um hashMap que é quem vai ser reponsável por "cruzar os dados"
        enviarValores.put(cpf.getText().toString(), valoresDono); // TODO 15 - aqui será passado para o hash chave e valor que serão enviados para o Firebase

        reference.updateChildren(enviarValores); // TODO 16 - esta linha é responsável por enviar os dados para o Firebase

        nomeDono.setText("");
        listaVacinas.clear();
        lista.setText("");


    }

    public void irPerfil(View v) {
        
    }

    public void adicionarVacina(View v){
        String nome = vacina.getText().toString();

        listaVacinas.add(nome);
        String listaNomes = "";

        if(!listaVacinas.isEmpty()){
            for (String nomes : listaVacinas) {
                listaNomes = listaNomes + nomes + "\n";
            }

            lista.setText(listaNomes);
            vacina.setText("");
        }

    }
}

