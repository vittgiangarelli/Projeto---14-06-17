package com.example.s2pet.s2pet.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AGUINALDO on 02/06/2017.
 */

public class Dono {

        private String nomeDono;
        private String cpf;
        private String email;
        private String nomePet;
        private String dataPeriodo;
        private List<String> listaVacina;

        public Dono(){}

    public Dono(String cpf, String nomeDono, String email, String nomePet, String dataPeriodo, List<String> listaVacina) {
        this.cpf = cpf;
        this.dataPeriodo = dataPeriodo;
        this.nomeDono = nomeDono;
        this.email = email;
        this.nomePet = nomePet;
        this.listaVacina = listaVacina;
    }

        // TODO 10 - criar um mapa de valores
        public Map<String, Object> mapaDeValores(){
            HashMap<String,Object> resultado = new HashMap<>();
            resultado.put("nomeDono", nomeDono);
            resultado.put("cpf", cpf);
            resultado.put("email", email);
            resultado.put("nomePet", nomePet);
            resultado.put("listaVacina", listaVacina);
            resultado.put("dataPeriodo", dataPeriodo);
            return resultado;
        }

        public List<String> getListaVacina() {
            return listaVacina;
        }

        public String getNomeDono() {
            return nomeDono;
        }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomePet() { return nomePet; }
}
