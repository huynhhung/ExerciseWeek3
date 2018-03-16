package com.example.inspiron.exerciseweek3;

/**
 * Created by Inspiron on 15-Mar-18.
 */

public class Movie {
    private String video;
    private String title;
    private String overview;
    private String poster_path;
    private String release_date;
    private String vote_average;
    public Movie() {

    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public boolean isVideo(String check){
        if (check.equals("false")){
            return false;
        }
        else{
            return true;
        }
    }
    @Override
    public String toString() {
        return "";
    }
}
