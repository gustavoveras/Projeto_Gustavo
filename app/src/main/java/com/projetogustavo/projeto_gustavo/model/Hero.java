package com.projetogustavo.projeto_gustavo.model;


import org.parceler.Parcel;

/**
 * Created by gustavoveras on 25/05/16.
 */
@Parcel
public class Hero {

    String nome;
    String feature;
    String image;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return nome + " - " + feature ;
    }


}


