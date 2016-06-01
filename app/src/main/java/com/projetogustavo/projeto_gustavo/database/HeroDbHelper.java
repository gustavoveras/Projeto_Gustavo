package com.projetogustavo.projeto_gustavo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gusta on 01/06/2016.
 */
public class HeroDbHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "heros_db";

    public HeroDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + HeroContract.TABLE_NAME + "( " +
                HeroContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HeroContract.NOME + " TEXT NOT NULL, " +
                HeroContract.FEATURE + " TEXT NOT NULL, " +
                HeroContract.IMAGE + "TEXT NOT NULL");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
