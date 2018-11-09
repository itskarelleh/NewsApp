package com.example.karelle.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();
    //Guardian URL
    private static final String REQUEST_URL = "https://content.guardianapis.com/search?q=animals&api-key=test";
    private ArticleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add ListView
        ListView articleListView = findViewById(R.id.list);
        //Create new list of articles with mAdapter
        mAdapter = new ArticleAdapter(this, new ArrayList<Article>());

        //Set mAdapter to ArticleListView
        articleListView.setAdapter(mAdapter);

        articleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Article currentArticle = mAdapter.getItem(position);

                Uri articleUri = Uri.parse(currentArticle.getmUrl());

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, articleUri);

                startActivity(websiteIntent);
            }
        });

        ArticleAsyncTask task = new ArticleAsyncTask();
        task.execute(REQUEST_URL);


    }

    private class ArticleAsyncTask extends AsyncTask<String, Void, List<Article>> {
        @Override
        protected List<Article> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null){
                return null;
            }
            List<Article> result = QueryUtils.fetchArticleData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<Article> data) {
            // Clear the adapter of previous earthquake data
            mAdapter.clear();

            // If there is a valid list of {@link Article}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }

        }
    }

    //End of ArticleAsyncTask
}
