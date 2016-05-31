package com.projetogustavo.projeto_gustavo;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projetogustavo.projeto_gustavo.model.Hero;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity implements HeroesFragment.ClickHeroListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void HeroClicked(Hero hero) {
        if (getResources().getBoolean(R.bool.tablet)) {

            DetailHeroFragment detailherofrag = DetailHeroFragment.newInstance(hero);
            getSupportFragmentManager().beginTransaction().replace(R.id.detail, detailherofrag, "detail").commit();
        }else {
            Intent it = new Intent(this, DetailHeroActivity.class);
            Parcelable p = Parcels.wrap(hero);
            it.putExtra(DetailHeroActivity.EXTRA_HERO, p);
            startActivity(it);
        }
    }
}
