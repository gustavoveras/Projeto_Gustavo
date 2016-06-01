package com.projetogustavo.projeto_gustavo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gusta on 31/05/2016.
 */
public class Dota {
    @SerializedName("dota")
    List<Position> positions;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
