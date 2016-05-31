package com.projetogustavo.projeto_gustavo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.projetogustavo.projeto_gustavo.model.Hero;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;


public class HeroesFragment extends Fragment {

    @Bind(R.id.list_heroes)
    ListView atbListView;
    List<Hero> atbHeroes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        atbHeroes = new ArrayList<>();
        atbHeroes.add(new Hero("Sven", "Hard Carry"));
        atbHeroes.add(new Hero("Pudge", "Mid"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_heroes, container, false);
        ButterKnife.bind(this, layout);


        atbListView.setAdapter(new ArrayAdapter<Hero>(
                getActivity(), android.R.layout.simple_list_item_1, atbHeroes));
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

    public interface ClickHeroListener {
        void HeroClicked(Hero hero);
    }

}
