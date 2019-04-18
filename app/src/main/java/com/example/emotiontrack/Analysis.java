package com.example.emotiontrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class Analysis extends AppCompatActivity {

    ImageButton back;
    ImageView emoji;
    TextView date;
    TextView tag1;
    TextView tag2;
    TextView tag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        /* intent setting */
        Intent intent = getIntent();
        String currentDATE = intent.getStringExtra("date");
        System.out.println("date"+ currentDATE);


        //int[] info = (int[]) intent.getSerializableExtra("this_emotion");
        int this_emotion = intent.getIntExtra("this_emotion",2);


        /* emoji */
        emoji = findViewById(R.id.this_emoji);
        if(this_emotion == 1) emoji.setBackgroundResource(R.drawable.laugh);
        else if(this_emotion == 2) emoji.setBackgroundResource((R.drawable.meh));
        else if(this_emotion == 3) emoji.setBackgroundResource(R.drawable.sad);

            // parse
        String[] dates = currentDATE.split(" ");

        /*  date */
        date = findViewById(R.id.this_date);
        date.setText(dates[0]);
        date = findViewById(R.id.this_day);
        date.setText(dates[1]);

        /* tags */
        tag1 = findViewById(R.id.tag_1);
        tag2 = findViewById(R.id.tag_2);
        tag3 = findViewById(R.id.tag_3);
        if(this_emotion == 1){
            tag1.setText("Love");
            tag2.setText("Excitement");
            tag3.setText("Happy");
        }
        else if(this_emotion == 2){
            tag1.setText("Peace");
            tag2.setText("Just So-so");
            tag3.setText("Nothing");
        }
        else if(this_emotion == 3){
            tag1.setText("Cry");
            tag2.setText("Exhausted");
            tag3.setText("Despair");
        }

        /* back button */
        back = findViewById(R.id.back_button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(Analysis.this, DashBoard.class));
            }
        });

    }
}
