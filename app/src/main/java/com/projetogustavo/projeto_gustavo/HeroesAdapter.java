package com.projetogustavo.projeto_gustavo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.projetogustavo.projeto_gustavo.model.Hero;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gusta on 01/06/2016.
 */
public class HeroesAdapter extends ArrayAdapter<Hero> {
    public HeroesAdapter(Context context, List<Hero> heroes) {
        super(context, 0, heroes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hero hero = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_hero, parent, false);
            viewHolder = new ViewHolder(convertView);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Glide.with(getContext()).load(hero.getImage()).into(viewHolder.imageView);
        viewHolder.txtNome.setText(hero.getNome());
        viewHolder.txtFeature.setText(hero.getFeature());

        return convertView;

    }

    static class ViewHolder {
        @Bind(R.id.image_foto)
        ImageView imageView;
        @Bind(R.id.text_nome)
        TextView txtNome;
        @Bind(R.id.text_feature)
        TextView txtFeature;

        public ViewHolder(View parent) {
            ButterKnife.bind(this, parent);
            parent.setTag(this);
        }
    }
}
