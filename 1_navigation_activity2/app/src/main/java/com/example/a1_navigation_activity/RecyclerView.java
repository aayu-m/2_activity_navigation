package com.example.a1_navigation_activity;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;

public class RecyclerView extends AppCompatActivity {

    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private List<Object> listItems = new ArrayList<>();
    private androidx.recyclerview.widget.RecyclerView.Adapter adapter;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
    private static final String tag = "recyclerActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(this,listItems);
        recyclerView.setAdapter(adapter);
        
        addItemsfromJson();
    }

    private void addItemsfromJson() {
        try{
            InputStream inputStream= getAssets().open("db.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String jsonString = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(jsonString);


            for(int i=0; i<jsonArray.length();i++){
                JSONObject movie = jsonArray.getJSONObject(i);

                String movieName = movie.getString("title");
                String writer = movie.getString("director");
                String releaseDate = movie.getString("year");

                Movie movieDetails = new Movie(movieName,writer,releaseDate);
                listItems.add(movieDetails);

            }
            Log.d("Myapp", String.valueOf(listItems.size()));
        }
        catch (IOException | JSONException e){
            Log.d("Myapp", "file not found");
        }
    }


}