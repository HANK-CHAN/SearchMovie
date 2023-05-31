package com.tw.ch.lcc.hankchan.searchmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ParseAdapter adapter;
    private ArrayList<MovieItem> movieItems = new ArrayList<>();
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Interest();

    }
    public void Interest(){
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.re_View);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ParseAdapter(movieItems,this);
        recyclerView.setAdapter(adapter);

        Content content = new Content();
        content.execute();
    }


    class Content extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            progressBar.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            progressBar.setVisibility(View.GONE);
            progressBar.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out));
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onCancelled(Void unused) {
            super.onCancelled(unused);
        }

        @Override
        protected Void doInBackground(Void... voids) {
           try{
            String url ="https://movies.yahoo.com.tw/movie_thisweek.html";
            Document doc = Jsoup.connect(url).get();

               Elements imgUrlLink = doc.select("div.release_foto");
               Elements titleLink = doc.select("div.release_info");

               for(int j = 0 ; j < titleLink.size() ; j++){

                   String imgUrl = imgUrlLink.get(j)
                           .select("img")
                           .attr("data-src");
                   String date = titleLink.get(j)
                           .select("div.release_movie_time")
                           .text();
                   String story = titleLink.get(j)
                           .select("div.release_text")
                           .text();
                   String title = titleLink.get(j)
                           .select("div.release_movie_name")
                           .select("a").first().text();
                   String link = imgUrlLink.get(j).select("a").attr("href");

                   movieItems.add(new MovieItem(imgUrl,title,link,date,story));
                   Log.d("items","data" +date+"story"+story);

               }
           } catch (IOException e) {
               e.printStackTrace();
           }
            return null;
        }
    }

}

