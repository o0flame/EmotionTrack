package com.example.emotiontrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ShareInput extends AppCompatActivity {

    Button shareButton;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_input);

        /* share button */
        shareButton = findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePopWindow popWindow = new SharePopWindow();
                popWindow.show(getSupportFragmentManager(), "popWindow");
            }
        });

        /* back button */
        back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(SelfReflectChoose.this, DashBoard.class));
            }
        });

        Button contact1 = findViewById(R.id.contact1);
        Button contact2 = findViewById(R.id.contact2);
        Button contact3 = findViewById(R.id.contact3);

        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareInput.this, SavePopWindow.class));
            }
        });
        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareInput.this, SavePopWindow.class));
            }
        });
        contact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareInput.this, SavePopWindow.class));
            }
        });


    }
}
