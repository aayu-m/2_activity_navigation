package com.example.a1_navigation_activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        String message= getIntent().getStringExtra("navigate_from");
        TextView textMsg = (TextView)findViewById(R.id.navigate_activity3);
        textMsg.setText(message);

        Button buttonGoHome = (Button) findViewById(R.id.goHome);
        buttonGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity3.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("navigate_from","From Third");
                setResult(3);
                startActivityForResult(i,2);
            }
        });

        Button buttonThirdToSecond = (Button) findViewById(R.id.goToSecond);
        buttonThirdToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity3.this, Activity2.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("navigate_from","From Third");
                setResult(3);
                startActivityForResult(i,2);
            }
        });

        Button buttonThirdToRecycler = (Button) findViewById(R.id.goToRecyclerView) ;
        buttonThirdToRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Myapp", "clicked");
                Intent i = new Intent(Activity3.this, RecyclerView.class);
                startActivity(i);
                
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView textMsg = (TextView)findViewById(R.id.navigate_activity3);
            if(resultCode==1) {
                textMsg.setText("FROM HOme");
            }
            else{
                textMsg.setText("FROM SECOND");
            }
        }
}