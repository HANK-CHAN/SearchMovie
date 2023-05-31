package com.tw.ch.lcc.hankchan.searchmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class introduce_tale extends AppCompatActivity {
    String trotxt, trolink,trodate,trotale;
    private TextView tit, date,link, story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_tale);

        Intert();

        Bundle bundle = getIntent().getExtras();
        trotxt = bundle.getString("introduce");
        trolink = bundle.getString("prolink");
        trodate = bundle.getString("inprodate");
        trotale = bundle.getString("tale");


        tit.setText(trotxt);
        link.setText(Html.fromHtml("<a href='http://www.google.com'/>"+trolink));
        date.setText(trodate);
        story.setText(trotale);


        tit.setMovementMethod(ScrollingMovementMethod.getInstance());
        link.setMovementMethod(ScrollingMovementMethod.getInstance());
        link.setMovementMethod(LinkMovementMethod.getInstance());
        date.setMovementMethod(ScrollingMovementMethod.getInstance());
        story.setMovementMethod(ScrollingMovementMethod.getInstance());

    }

    public void Intert() {
        tit = findViewById(R.id.titext);
        date = findViewById(R.id.textdate);
//        time = findViewById(R.id.movieti);
        link = findViewById(R.id.link);
        story = findViewById(R.id.textstory);



    }

}