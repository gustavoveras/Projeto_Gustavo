package com.projetogustavo.projeto_gustavo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HeroesFragment.ClickHeroListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void HeroClicked(Hero hero) {

        DetailHeroFragment detailherofrag = DetailHeroFragment.newInstance(hero);
        getSupportFragmentManager().beginTransaction().replace(R.id.detail, detailherofrag, "detail").commit();
    }
}
