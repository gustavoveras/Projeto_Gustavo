package com.projetogustavo.projeto_gustavo;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projetogustavo.projeto_gustavo.model.Hero;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DetailHeroFragment extends Fragment {

    private static final String EXTRA_HERO = "param1";

    @Bind(R.id.text_nome)
    TextView atbtxtNome;
    @Bind(R.id.text_funcao)
    TextView atbtxtFuncao;
    TextView atbtxtFeature;

    private Hero atbHero;

    public static DetailHeroFragment newInstance(Hero hero) {
        DetailHeroFragment fragment = new DetailHeroFragment();
        Bundle args = new Bundle();
        Parcelable p = Parcels.wrap(hero);
        args.putParcelable(EXTRA_HERO, p);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Parcelable p = getArguments().getParcelable(EXTRA_HERO);
            atbHero = Parcels.unwrap(p);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_hero, container, false);
        ButterKnife.bind(this, view);
        atbtxtNome.setText(atbHero.getNome());
        atbtxtFeature.setText(atbHero.getFeature());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
