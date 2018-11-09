package com.example.karelle.newsapp;

public class Article {

    private String mTitle;
    private String mAuthor;
    private int mDate;
    private int mImage;
    private String mCategory;
    private String mUrl;

    public Article(String title, String author, int date, int image, String category, String url){
        mTitle = title;
        mAuthor = author;
        mDate = date;
        mImage = image;
        mCategory = category;
        mUrl = url;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmAuthor(){
        return mAuthor;
    }

    public int getmDate(){
        return mDate;
    }

    public int getmImage() {
        return mImage;
    }

    public String getmCategory(){
        return mCategory;
    }

    public String getmUrl(){
        return mUrl;
    }
}
