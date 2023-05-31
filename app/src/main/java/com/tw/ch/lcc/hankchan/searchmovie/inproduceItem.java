package com.tw.ch.lcc.hankchan.searchmovie;

public class inproduceItem {

    String date ;
    String movie_time;
    String link;
    String story;

    public inproduceItem(String date, String movie_time, String link, String story) {
        this.date = date;
        this.movie_time = movie_time;
        this.link = link;
        this.story = story;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMovie_time() {
        return movie_time;
    }

    public void setMovie_time(String movie_time) {
        this.movie_time = movie_time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
