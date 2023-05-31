package com.tw.ch.lcc.hankchan.searchmovie;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class ParseAdapter extends RecyclerView.Adapter<ParseAdapter.ViewHolder> {

    private ArrayList<MovieItem> movieItems;
    public Context context;

    public ParseAdapter(ArrayList<MovieItem> movieItems,Context context){
        this.movieItems = movieItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ParseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parse_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieItem movieItem = movieItems.get(position);
        holder.textView.setText(movieItem.getTitle());

        Picasso.get().load(movieItem.getImgUrl()).into(holder.imgview);

        holder.itemView.setOnClickListener(view -> {
            Intent it = new Intent();

            Bundle bundle = new Bundle();
            bundle.putSerializable("introduce",movieItem.getTitle());
            bundle.putSerializable("prolink",movieItem.getLink());
            bundle.putSerializable("inprodate",movieItem.getDate());
            bundle.putSerializable("tale",movieItem.getStory());
            it.putExtras(bundle);

            it.setClass(view.getContext(), introduce_tale.class);

            view.getContext().startActivity(it);

        });

    }

    @Override
    public int getItemCount() {
        return movieItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgview;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.imgView);
            textView = itemView.findViewById(R.id.textView);

        }
    }
    
}