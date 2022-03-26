package com.tw.ch.lcc.hankchan.searchmovie;

public class MovieItem {

    private String imgUrl;
    private String title;

    public MovieItem() {
    }

    public MovieItem(String imgUrl, String title) {
        this.imgUrl = imgUrl;
        this.title = title;
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
}
