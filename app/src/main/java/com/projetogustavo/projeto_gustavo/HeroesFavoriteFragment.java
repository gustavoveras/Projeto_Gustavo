package com.projetogustavo.projeto_gustavo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.projetogustavo.projeto_gustavo.database.HeroDAO;
import com.projetogustavo.projeto_gustavo.model.Hero;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;


public class HeroesFavoriteFragment extends Fragment {

    @Bind(R.id.list_heroes)
    ListView atbListView;


    List<Hero> atbHeroes;
    ArrayAdapter<Hero> atbAdapter;
    HeroDAO atbDao;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        atbDao = new HeroDAO(getActivity());
        atbHeroes = atbDao.listar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_favourites_heroes, container, false);
        ButterKnife.bind(this, layout);

        atbAdapter = new HeroesAdapter(getContext(), atbHeroes);
        atbListView.setAdapter(atbAdapter);

        return layout;
    }



    @OnItemClick(R.id.list_heroes)
    void onItemSelected(int position) {
        Hero hero = atbHeroes.get(position);
        if (getActivity() instanceof ClickHeroListener) {
            ClickHeroListener listener = (ClickHeroListener) getActivity();
            listener.HeroClicked(hero);
        }

    }

}
