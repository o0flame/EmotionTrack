package com.example.emotiontrack;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class ChangeStatusPopWindow extends Activity {
    Button e1, e2, e3, e4, e5,e6,e7,e8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status_pop_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        getWindow().setLayout((int)(dm.widthPixels), (int)(dm.heightPixels*0.4));

        // buttons setting
        e1 = findViewById(R.id.emotion1);
        e2 = findViewById(R.id.emotion2);
        e3 = findViewById(R.id.emotion3);
        e4 = findViewById(R.id.emotion4);
        e5 = findViewById(R.id.emotion5);
        e6 = findViewById(R.id.emotion6);
        e7 = findViewById(R.id.emotion7);
        e8 = findViewById(R.id.emotion8);

        //click actions
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setResult(1,new Intent());
                finish();
            }
        });

        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(2,new Intent());
                finish();
            }
        });

        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(3,new Intent());
                finish();
            }
        });

        e4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(4,new Intent());
                finish();
            }
        });

        e5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(5,new Intent());
                finish();
            }
        });

        e6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(6,new Intent());
                finish();
            }
        });

        e7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(7,new Intent());
                finish();
            }
        });

        e8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(8,new Intent());
                finish();
            }
        });

    }
}
