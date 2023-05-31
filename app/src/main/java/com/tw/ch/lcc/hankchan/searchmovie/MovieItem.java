package com.tw.ch.lcc.hankchan.searchmovie;

public class MovieItem {

    private String imgUrl;
    private String title;
    private String link;
    private String date;
    private String story;

    public MovieItem(String imgUrl, String title, String link, String date, String story) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.link = link;
        this.date = date;
        this.story = story;
    }

    public MovieItem() {
    }

    public MovieItem(String imgUrl, String title) {
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public MovieItem(String imgUrl, String title, String link) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.link = link;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
