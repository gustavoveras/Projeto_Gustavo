package com.projetogustavo.projeto_gustavo.model;

import java.util.List;

/**
 * Created by gusta on 31/05/2016.
 */
public class Position {
    String name;
    List<Hero> heroes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}
