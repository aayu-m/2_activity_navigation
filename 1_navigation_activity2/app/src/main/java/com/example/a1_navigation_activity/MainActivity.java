package com.example.a1_navigation_activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button buttonFirstToSecond = (Button) findViewById(R.id.firstToSecond);
       buttonFirstToSecond.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(MainActivity.this, Activity2.class);
               i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(i);
           }
       });

        Button buttonFirstToThird = (Button) findViewById(R.id.firstToThird);
        buttonFirstToThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity3.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        Button buttonCloseApp = (Button) findViewById(R.id.closeApp);
        buttonCloseApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }

}