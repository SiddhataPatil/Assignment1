package com.codepath.siddhatapatil.flicksassgn1.Adapters;

import android.content.Context;
import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.List;
import android.view.View;
import android.widget.TextView;

import com.codepath.siddhatapatil.flicksassgn1.R;
import com.codepath.siddhatapatil.flicksassgn1.models.Movie;

import org.w3c.dom.Text;

/**
 * Created by siddhatapatil on 9/16/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie>{
    public MovieArrayAdapter(Context context, List<Movie> movies)
    {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent)
    {
        Movie movie = getItem(position);
        if (convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_movie,parent, false);
        }
        ImageView ivImage = (ImageView)convertView.findViewById(R.id.movieImage);
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        return convertView;
    }
}
