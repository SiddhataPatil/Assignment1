package com.codepath.siddhatapatil.flicksassgn1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.siddhatapatil.flicksassgn1.models.Movie;
import com.codepath.siddhatapatil.flicksassgn1.R;

/**
 * Created by siddhatapatil on 9/17/17.
 */

public class MovieDetailAdapter extends ArrayAdapter<Movie> {
    public MovieDetailAdapter(Context context, int resource) {
        super(context, resource);
    }

    private static class ViewHolder
    {
        TextView popularity;
        TextView synopsis;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.movie_detail, parent, false);
            viewHolder.popularity = (TextView) convertView.findViewById(R.id.pop);
            viewHolder.synopsis = (TextView) convertView.findViewById(R.id.syn);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.popularity.setText(movie.getPopularity());
        viewHolder.synopsis.setText(movie.getOverview());
        return convertView;
    }
}
