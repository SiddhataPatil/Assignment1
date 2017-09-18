package com.codepath.siddhatapatil.flicksassgn1.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by siddhatapatil on 9/16/17.
 */

public class Movie {
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("http://image.tmdb.org/t/p/w780/%s", BackdropPath);
    }

    public String getBackdropPath1() {
        return String.format("http://image.tmdb.org/t/p/w1280/%s", BackdropPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Double getVotes() {return Votes;}

    public String getPopularity() {return popularity;}

    String posterPath;
    String BackdropPath;
    String originalTitle;
    String overview;
    Double Votes;
    String popularity;

    public Movie(JSONObject jsonObject) throws JSONException
    {
        this.posterPath = jsonObject.getString("poster_path");
        this.BackdropPath=jsonObject.getString("backdrop_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.Votes = jsonObject.getDouble("vote_average");
        this.popularity = jsonObject.getString("popularity");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array)
    {
        ArrayList<Movie> results = new ArrayList<>();
        for (int i=0; i<array.length(); i++)
        {
            try {
                results.add(new Movie(array.getJSONObject(i)));
                } catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
        }
        return results;
    }
}


