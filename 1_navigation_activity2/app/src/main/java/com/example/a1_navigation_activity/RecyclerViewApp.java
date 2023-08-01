package com.example.a1_navigation_activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewApp extends AppCompatActivity {

    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private List<Object> listItems = new ArrayList<>();
    private androidx.recyclerview.widget.RecyclerView.Adapter adapter;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
    private static final String tag = "recyclerActivity";
    public LruCache<String, Bitmap> memoryCache= new LruCache<>(3);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_acquisitiom);
        Log.d("Myapp", "layout for App Acq");

        recyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.recycler_view_app);
        layoutManager = new LinearLayoutManager(this);
        addItemsfromJson();
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapterApp(this,listItems,memoryCache);
        recyclerView.setAdapter(adapter);

    }

    private void addItemsfromJson() {
        try{
            InputStream inputStream= getAssets().open("AppData.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String jsonString = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(jsonString);


            for(int i=0; i<jsonArray.length();i++){
                JSONObject app = jsonArray.getJSONObject(i);

                String appName = app.getString("name");
                String appDesc = app.getString("appDescription");
                String appDev = app.getString("developedBy");
                String logoLink = app.getString("iconUrl");

                Application appDetails = new Application(appName,appDev,appDesc,logoLink);
                listItems.add(appDetails);

            }
            Log.d("Myapp", String.valueOf(listItems.size()));
        }
        catch (IOException | JSONException e){
            Log.d("Myapp", "file not found");
        }
    }







}