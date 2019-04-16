package com.example.emotiontrack;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.Serializable;

public class ChangeStatus extends AppCompatActivity {

    ImageButton changeEmojiButton;
    ImageButton backButton;
    Button cancelButton;
    Button confirmButton;

    int emojiId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status);

        /* buttons setting */
        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        confirmButton = (Button) findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("this emotion", emojiId);
                setResult(1, intent);
                finish();
            }
        });

        /*change emoji*/
        changeEmojiButton = (ImageButton) findViewById(R.id.change_emoji_button);
        changeEmojiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeStatus.this, ChangeStatusPopWindow.class);
                startActivityForResult(intent, 1);
                //startActivity(new Intent(ChangeStatus.this, ChangeStatusPopWindow.class));
            }
        });


    }// onCreate end

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == 1) {
                changeEmojiButton.setBackgroundResource(R.drawable.e1);
                emojiId = 1;
            }else if(resultCode == 2){
                changeEmojiButton.setBackgroundResource(R.drawable.e2);
                emojiId = 2;
            }else if(resultCode == 3){
                changeEmojiButton.setBackgroundResource(R.drawable.e3);
                emojiId = 3;
            }else if(resultCode == 4){
                changeEmojiButton.setBackgroundResource(R.drawable.e4);
                emojiId = 4;
            }else if(resultCode == 5){
                changeEmojiButton.setBackgroundResource(R.drawable.e5);
                emojiId = 5;
            }else if(resultCode == 6){
                changeEmojiButton.setBackgroundResource(R.drawable.e6);
                emojiId = 6;
            }else if(resultCode == 7){
                changeEmojiButton.setBackgroundResource(R.drawable.e7);
                emojiId = 7;
            }else if(resultCode == 8){
                changeEmojiButton.setBackgroundResource(R.drawable.e8);
                emojiId = 8;
            }else{
                emojiId = -1;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
