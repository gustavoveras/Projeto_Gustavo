package com.projetogustavo.projeto_gustavo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projetogustavo.projeto_gustavo.model.Hero;

import org.parceler.Parcels;

public class DetailHeroActivity extends AppCompatActivity {

    public static final String EXTRA_HERO = "hero";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hero);

        Hero hero = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_HERO));;

        DetailHeroFragment detailherofrag = DetailHeroFragment.newInstance(hero);
        getSupportFragmentManager().beginTransaction().replace(R.id.detail, detailherofrag, "detail").commit();
    }
}
