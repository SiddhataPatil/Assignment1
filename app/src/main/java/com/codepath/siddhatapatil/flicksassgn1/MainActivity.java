package com.codepath.siddhatapatil.flicksassgn1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codepath.siddhatapatil.flicksassgn1.models.Movie;
import com.loopj.android.http.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //super.onSuccess(statusCode, headers, response);
                JSONArray moviejasonResults = null;
                try {
                    moviejasonResults = response.getJSONArray("results");
                    movies = Movie.fromJSONArray(moviejasonResults);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });

    }
}
