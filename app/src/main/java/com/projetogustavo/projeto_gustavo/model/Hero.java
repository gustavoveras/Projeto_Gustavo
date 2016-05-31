package com.projetogustavo.projeto_gustavo.model;


import org.parceler.Parcel;

/**
 * Created by gustavoveras on 25/05/16.
 */
@Parcel
public class Hero {

    String nome;
    String funcao;

    public Hero() {
    }

    public Hero(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return nome + " - " + funcao;
    }


}


