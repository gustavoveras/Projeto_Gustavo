package com.projetogustavo.projeto_gustavo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.projetogustavo.projeto_gustavo.model.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gusta on 01/06/2016.
 */
public class HeroDAO {

    private Context atbContext;

    public HeroDAO(Context atbContext) {
        this.atbContext = atbContext;
    }

    public long inserir(Hero hero){
        HeroDbHelper helper = new HeroDbHelper(atbContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = valuesFromHero(hero);

        long id = db.insert(HeroContract.TABLE_NAME, null, values);

        hero.setId(id);
        db.close();
        return id;
    }

    public int atualizar(Hero hero){
        HeroDbHelper helper = new HeroDbHelper(atbContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = valuesFromHero(hero);


        int rowsAffected = db.update(HeroContract.TABLE_NAME, values,
                HeroContract._ID +" = ?",
                new  String[]{ String.valueOf(hero.getId())} );

        db.close();
        return rowsAffected;
    }

    public int excluir(Hero hero){
        HeroDbHelper helper = new HeroDbHelper(atbContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        int rowsAffected = db.delete(HeroContract.TABLE_NAME,
                 HeroContract._ID +"= ?",
                new  String[]{String.valueOf(hero.getId())});
        db.close();
        return rowsAffected;
    }

    public List<Hero> listar(){
        HeroDbHelper helper = new HeroDbHelper(atbContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + HeroContract.TABLE_NAME, null);
        List<Hero> heroes = new ArrayList<>();
        while (cursor.moveToNext()) {
            Hero hero = new Hero();
            hero.setId(cursor.getLong(cursor.getColumnIndex(HeroContract._ID)));
            hero.setNome(cursor.getString(cursor.getColumnIndex(HeroContract.NOME)));
            hero.setFeature(cursor.getString(cursor.getColumnIndex(HeroContract.FEATURE)));
            hero.setImage(cursor.getString(cursor.getColumnIndex(HeroContract.IMAGE)));

            heroes.add(hero);
        }
        cursor.close();
        db.close();
        return heroes;
    }

    private ContentValues valuesFromHero(Hero hero){

        ContentValues values = new ContentValues();
        values.put(HeroContract.NOME, hero.getNome());
        values.put(HeroContract.FEATURE, hero.getFeature());
        values.put(HeroContract.IMAGE, hero.getImage());

        return values;
    }


}
