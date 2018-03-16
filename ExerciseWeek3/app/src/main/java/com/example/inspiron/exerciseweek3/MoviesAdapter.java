package com.example.inspiron.exerciseweek3;

/**
 * Created by Inspiron on 15-Mar-18.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{
    // Store a member variable for the movies
    private List<Movie> mMovies;
    // Store the context for easy access
    private Context mContext;

    // Pass in the movie array into the constructor
    public MoviesAdapter(Context context, List<Movie> movies) {
        mMovies = movies;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View movieView = inflater.inflate(R.layout.item_movie, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(movieView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MoviesAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Movie movie = mMovies.get(position);
        // Set item views based on your views and data model
        TextView tvTitle = viewHolder.txtvTitle;
        tvTitle.setText(movie.getTitle());
        TextView tvDescription = viewHolder.txtvDescription;
        tvDescription.setText(movie.getOverview());
        ImageView imPoster = viewHolder.imgPoster;
        Picasso.get().load("http://image.tmdb.org/t/p/w500/" + movie.getPoster_path()).into(imPoster);
        ImageButton btnPlay = viewHolder.btnVideo;
        btnPlay.setBackgroundResource(movie.isVideo(movie.getVideo()) ? R.drawable.button_3_512 : R.drawable.prohibited_155486_640);



    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView txtvTitle;
        public TextView txtvDescription;
        public ImageView imgPoster;
        public ImageButton btnVideo;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            itemView.setOnClickListener(this);
            txtvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            txtvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            imgPoster = (ImageView) itemView.findViewById(R.id.imgPoster);
            btnVideo = (ImageButton) itemView.findViewById(R.id.imgPlay);

        }
        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            Movie movie = mMovies.get(position);
            openDetailActivity(movie.getTitle(),movie.getPoster_path(),movie.getOverview(),movie.getRelease_date(),movie.getVote_average());
        }
    }

    private void openDetailActivity(String title, String path_poster, String overview, String releaseDate, String vote_average)
    {
        Intent i=new Intent(mContext, MovieDetailActivity.class);

        //PACK DATA TO SEND
        i.putExtra("title",title);
        i.putExtra("path_poster",path_poster);
        i.putExtra("overview",overview);
        i.putExtra("vote_average",vote_average);
        i.putExtra("releaseDate","Release Date: " + releaseDate);
        //open activity
        mContext.startActivity(i);

    }
}
