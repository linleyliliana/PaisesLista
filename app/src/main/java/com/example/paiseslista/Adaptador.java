package com.example.paiseslista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class Adaptador extends ArrayAdapter<ListaPaises> {
    public Adaptador(Context context, ArrayList<ListaPaises> datos) {
        super(context,R.layout.lyitem,datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitem,null);


        TextView lblPais = (TextView)item.findViewById(R.id.lblPais);
        lblPais.setText(getItem(position).getName());
        ImageView imageView = (ImageView)item.findViewById(R.id.imgPic);
        Glide.with(this.getContext())
                .load(getItem(position).getIso2()).into(imageView);
        return (item);
    }
}