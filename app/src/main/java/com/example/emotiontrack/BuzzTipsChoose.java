package com.example.emotiontrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

public class BuzzTipsChoose extends AppCompatActivity {

    ImageButton back;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    ImageButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzz_tips_choose);

        /* back button */
        back = findViewById(R.id.back_button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivityForResult(new Intent(BuzzTipsChoose.this, DashBoard.class), 1);
            }
        });

        /* next button */
        nextButton = findViewById(R.id.next_button);
        nextButton.setEnabled(false);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuzzTipsChoose.this, BuzzTipsOverview.class));
            }
        });

        /* check boxes */
        checkBox1 = findViewById(R.id.checkbox_1);
        checkBox2 = findViewById(R.id.checkbox_2);
        checkBox3 = findViewById(R.id.checkbox_3);
        checkBox4 = findViewById(R.id.checkbox_4);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked()){
                    nextButton.setEnabled(true);
                    nextButton.setBackgroundResource(R.drawable.next_buttopn);
                }else{
                    nextButton.setEnabled(false);
                    nextButton.setBackgroundResource(R.drawable.next_button_not);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked()){
                    nextButton.setEnabled(true);
                    nextButton.setBackgroundResource(R.drawable.next_buttopn);
                }else{
                    nextButton.setEnabled(false);
                    nextButton.setBackgroundResource(R.drawable.next_button_not);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked()){
                    nextButton.setEnabled(true);
                    nextButton.setBackgroundResource(R.drawable.next_buttopn);
                }else{
                    nextButton.setEnabled(false);
                    nextButton.setBackgroundResource(R.drawable.next_button_not);
                }
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked()){
                    nextButton.setEnabled(true);
                    nextButton.setBackgroundResource(R.drawable.next_buttopn);
                }else{
                    nextButton.setEnabled(false);
                    nextButton.setBackgroundResource(R.drawable.next_button_not);
                }
            }
        });
    }
}
