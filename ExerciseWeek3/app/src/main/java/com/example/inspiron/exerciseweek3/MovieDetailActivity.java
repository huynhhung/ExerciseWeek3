package com.example.inspiron.exerciseweek3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class MovieDetailActivity extends AppCompatActivity {

    ImageView imgPoster;
    TextView txtvTitle, txtvReleaseDate, txtvOverview;
    RatingBar rbVotePoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        imgPoster = (ImageView) findViewById(R.id.imgPosterDetail);
        txtvOverview = (TextView) findViewById(R.id.tvOverview);
        txtvReleaseDate = (TextView)findViewById(R.id.tvReleaseDate);
        txtvTitle = (TextView) findViewById(R.id.tvTitleMovieDetail);
        rbVotePoint = (RatingBar) findViewById(R.id.rbReview);
        Intent i=this.getIntent();
        txtvTitle.setText(i.getExtras().getString("title"));
        txtvOverview.setText(i.getExtras().getString("overview"));
        Picasso.get().load("http://image.tmdb.org/t/p/w500/" + i.getExtras().getString("path_poster")).into(imgPoster);
        txtvReleaseDate.setText(i.getExtras().getString("releaseDate"));
        //txtvReleaseDate.setText(i.getExtras().getString("vote_average"));
        float point = Float.parseFloat(i.getExtras().getString("vote_average"));
        rbVotePoint.setRating((point*5)/10);
    }
}
