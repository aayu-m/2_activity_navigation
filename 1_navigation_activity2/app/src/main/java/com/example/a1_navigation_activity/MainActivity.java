package com.example.a1_navigation_activity;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void go_to_second(View view){
        Intent switchToSecond = new Intent(this, Activity2.class);
        startActivity(switchToSecond);
    }
    public void close_app(View view) {
        finish();
    }
}