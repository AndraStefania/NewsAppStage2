package com.example.android.newsappstage2;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by stefania.fanaru.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /**
     * Query URL
     */
    private String url;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (url == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract the news list.

        List<News> news = null;
        try {
            news = Utility.fetchNewsData(url);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return news;
    }
}
