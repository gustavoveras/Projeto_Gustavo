package com.projetogustavo.projeto_gustavo.database;

import android.provider.BaseColumns;

/**
 * Created by gusta on 01/06/2016.
 */
public interface HeroContract extends BaseColumns {
    String TABLE_NAME = "heros";
    String NOME = "nome";
    String FEATURE = "feature";
    String IMAGE = "imagem";

}
