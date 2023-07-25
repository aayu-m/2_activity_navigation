package com.example.a1_navigation_activity;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String message= getIntent().getStringExtra("navigate_from");
        TextView textMsg = (TextView)findViewById(R.id.navigate_activity2);
        textMsg.setText(message);





        Button buttonSecondToThird = (Button) findViewById(R.id.secondToThird);
        buttonSecondToThird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Activity2.this, Activity3.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("navigate_from","From Second");
                setResult(2);
                startActivityForResult(i,2);
            }
        });

        Button buttonGoBack = (Button) findViewById(R.id.goBack);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Activity2.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("navigate_from","From Second");
                setResult(2);
                startActivityForResult(i,2);
            }
        });


    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            TextView textMsg = (TextView) findViewById(R.id.navigate_activity2);
            if(resultCode==1) {
                textMsg.setText("FROM HOME");
            }
            else{
                textMsg.setText("FROM THIRD");
            }
        }

}