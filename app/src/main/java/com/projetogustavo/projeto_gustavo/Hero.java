package com.projetogustavo.projeto_gustavo;

/**
 * Created by gustavoveras on 25/05/16.
 */
public class Hero {

    String nome;
    String funcao;

    public Hero(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return nome +" - " + funcao;
    }
}
