package com.example.inspiron.exerciseweek3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //ArrayList<Movie> movies;
    List<Movie> movieList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvMovies = findViewById(R.id.recycler_view);
        try {
            JSONObject jsonObject = new JSONObject(MyApp.msgMovie);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            movieList = new ArrayList<>();
            Gson gson = new Gson();
            for (int i = 0; i<jsonArray.length();i++){
                JSONObject finalObject = jsonArray.getJSONObject(i);
                Movie movie = gson.fromJson(finalObject.toString(),Movie.class);
                movieList.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Create adapter passing in the sample user data
        MoviesAdapter adapter = new MoviesAdapter(this, movieList);
        // Attach the adapter to the recyclerview to populate items
        rvMovies.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rvMovies.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        rvMovies.addItemDecoration(dividerItemDecoration);
    }
}
