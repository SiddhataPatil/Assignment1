package com.codepath.siddhatapatil.flicksassgn1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.codepath.siddhatapatil.flicksassgn1.Adapters.MovieArrayAdapter;
import com.codepath.siddhatapatil.flicksassgn1.Adapters.MovieDetailAdapter;
import com.codepath.siddhatapatil.flicksassgn1.models.Movie;
import com.loopj.android.http.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.BindView;

import cz.msebera.android.httpclient.Header;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import okhttp3.OkHttpClient;

/*
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
*/

public class MainActivity extends AppCompatActivity  {

    ArrayList<Movie> movies;
    MovieArrayAdapter movieAdapter;
    ListView lvitems;
    @BindView(R.id.ibplay) ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvitems= (ListView) findViewById(R.id.lvMovies);
        movies = new ArrayList<>();
        movieAdapter = new MovieArrayAdapter(this, movies);
        lvitems.setAdapter(movieAdapter);
        //OkHttpClient client = new OkHttpClient();

        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //super.onSuccess(statusCode, headers, response);
                JSONArray moviejasonResults = null;
                try {
                    moviejasonResults = response.getJSONArray("results");
                    movies.addAll(Movie.fromJSONArray(moviejasonResults));
                    movieAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }

        });
/*
        Intent i = new Intent(MainActivity.this,
                MovieDetailActivity.class);
        startActivity(i);
        */
    }
    public void launchComposeView() {
        // first parameter is the context, second is the class of the activity to launch
        ButterKnife.bind(this);
        //button = (ImageButton) findViewById(R.id.ibplay) ;
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, MovieDetailAdapter.class);
                startActivity(i); // brings up the second activity
            }
    });
    }

    Button button1;

}
