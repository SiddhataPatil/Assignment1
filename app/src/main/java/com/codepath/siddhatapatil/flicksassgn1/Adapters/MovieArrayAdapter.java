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
import com.squareup.picasso.Picasso;

import android.content.res.Configuration;

import org.w3c.dom.Text;


/**
 * Created by siddhatapatil on 9/16/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie>{

    private static class ViewHolder
    {
        TextView title;
        TextView overview;
    }

    public MovieArrayAdapter(Context context, List<Movie> movies)
    {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent)
    {
        Movie movie = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_movie,parent, false);
            viewHolder.title=(TextView)convertView.findViewById(R.id.tvTitle);
            viewHolder.overview=(TextView)convertView.findViewById(R.id.tvOverview);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.title.setText(movie.getOriginalTitle());
        viewHolder.overview.setText(movie.getOverview());
/*
        ImageView ivImage = (ImageView)convertView.findViewById(R.id.movieImage);
        ivImage.setImageResource(0);
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
*/
        //TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        //TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //tvTitle.setText(movie.getOriginalTitle());
        //tvOverview.setText(movie.getOverview());

        //Populate Images

        int orientation = getContext().getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) //1
        {
                ImageView ivImage = (ImageView)convertView.findViewById(R.id.movieImage);
                ivImage.setImageResource(0);
                //Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
                Picasso.with(getContext()).load(movie.getPosterPath())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder_error)
                    .into(ivImage);

        }
        else if (orientation == Configuration.ORIENTATION_LANDSCAPE) //2
        {
                ImageView ivImage_landscape = (ImageView)convertView.findViewById(R.id.movieImage1);
                ivImage_landscape.setImageResource(0);
                //Picasso.with(getContext()).load(movie.getBackdropPath()).into(ivImage_landscape);
                Picasso.with(getContext()).load(movie.getBackdropPath())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder_error)
                    .into(ivImage_landscape);
        }

      return convertView;
    }
}
