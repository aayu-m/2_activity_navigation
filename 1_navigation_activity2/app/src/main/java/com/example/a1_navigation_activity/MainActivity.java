package com.example.a1_navigation_activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String message= getIntent().getStringExtra("navigate_from");
        TextView textMsg = (TextView)findViewById(R.id.navigate_activity1);
        textMsg.setText(message);

       Button buttonFirstToSecond = (Button) findViewById(R.id.firstToSecond);
       buttonFirstToSecond.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent i = new Intent(MainActivity.this, Activity2.class);
               i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               i.putExtra("navigate_from","From Home");
               setResult(1);
               startActivityForResult(i,2);
           }
       });

        Button buttonFirstToThird = findViewById(R.id.firstToThird);
        buttonFirstToThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Activity3.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("navigate_from","From Home");
                setResult(1);
                startActivityForResult(i,2);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            TextView textMsg = (TextView) findViewById(R.id.navigate_activity1);
        if(resultCode==2) {
            textMsg.setText("FROM Second");
        }
        else{
            textMsg.setText("FROM Third");
        }
    }

}