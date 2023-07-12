package com.example.a1_navigation_activity;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


    }
    public void go_to_third(View view){
        finish();
        Intent switchToThird = new Intent(this, Activity3.class);
        startActivity(switchToThird);
    }
    public void go_back(View view) {
        finish();
    }

}