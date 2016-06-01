package com.projetogustavo.projeto_gustavo;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.projetogustavo.projeto_gustavo.model.Dota;
import com.projetogustavo.projeto_gustavo.model.Hero;
import com.projetogustavo.projeto_gustavo.model.Position;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HeroesFragment extends Fragment {

    @Bind(R.id.list_heroes)
    ListView atbListView;
    List<Hero> atbHeroes;
    ArrayAdapter<Hero> atbAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_heroes, container, false);
        ButterKnife.bind(this, layout);

        atbHeroes = new ArrayList<>();
        atbAdapter = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_list_item_1, atbHeroes);
        atbListView.setAdapter(atbAdapter);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new HeroesTask().execute();
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

    class HeroesTask extends AsyncTask<Void, Void, Dota> {

        @Override
        protected Dota doInBackground(Void... params) {

            OkHttpClient client = new OkHttpClient();


            Request request = new Request.Builder()
                    .url("https://dl.dropboxusercontent.com/s/mp1fwit2sw1jv9p/Heroes.json?dl=0")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                String jsonString = response.body().string();
                Log.d("NGVL", jsonString);
                Gson gson = new Gson();
                Dota dota = gson.fromJson(jsonString, Dota.class);
                return dota;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Dota dota) {
            super.onPostExecute(dota);

            if (dota != null){
                atbHeroes.clear();
                for (Position position: dota.getPositions()){
                    atbHeroes.addAll(position.getHeroes());

                }
                atbAdapter.notifyDataSetChanged();
            }
        }
    }
}
