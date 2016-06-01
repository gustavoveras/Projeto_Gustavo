package com.projetogustavo.projeto_gustavo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.projetogustavo.projeto_gustavo.model.Hero;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ClickHeroListener{

    @Bind(R.id.viewPager)
    ViewPager atbViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        atbViewPager.setAdapter(new HeroPager(getSupportFragmentManager()));

    }

    class HeroPager extends FragmentPagerAdapter{

        public HeroPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) return new HeroesFragment();
            return new HeroesFavoriteFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
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
