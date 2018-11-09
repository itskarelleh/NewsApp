package com.example.karelle.newsapp;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class ArticleAdapter extends ArrayAdapter<Article> {
    public ArticleAdapter(Activity context, ArrayList<Article> articles){
        super(context, 0, articles);
    }

    @Override
    @Nullable
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView;
        listItemView = convertView;
        if (listItemView == null){
            LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Article currentArticle = getItem(position);

        String articleTitle = currentArticle.getmTitle();
        String articleAuthor = currentArticle.getmAuthor();
        int articleDate = currentArticle.getmDate();
        int articleImage = currentArticle.getmImage();
        String articleCategory = currentArticle.getmCategory();

        TextView titleTextView = listItemView.findViewById(R.id.title_textview);
        titleTextView.setText(articleTitle);

        TextView authorTextView = listItemView.findViewById(R.id.author_textview);
        authorTextView.setText(articleAuthor);

        TextView dateTextView = listItemView.findViewById(R.id.date_textview);
        dateTextView.setText(articleDate);

        ImageView articleImageView = listItemView.findViewById(R.id.thumbnail);
        articleImageView.setImageResource(articleImage);

        TextView categoryTextView = listItemView.findViewById(R.id.category_textview);
        categoryTextView.setText(articleCategory);
        return listItemView;
    }
}
