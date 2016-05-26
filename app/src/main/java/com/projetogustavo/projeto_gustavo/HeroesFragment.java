package com.projetogustavo.projeto_gustavo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class HeroesFragment extends Fragment {

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
        ListView listView = (ListView)layout.findViewById(R.id.list_heroes);
        listView.setAdapter(new ArrayAdapter<Hero>(
                getActivity(), android.R.layout.simple_list_item_1, atbHeroes));

        return layout;
    }

}
