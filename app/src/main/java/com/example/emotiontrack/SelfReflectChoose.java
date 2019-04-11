package com.example.emotiontrack;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

public class SelfReflectChoose extends AppCompatActivity {

    ImageButton back;
//    ImageButton chooseButton1;
//    ImageButton chooseButton2;
//    ImageButton chooseButton3;
//    ImageButton chooseButton4;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    ImageButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_reflect_choose);

        /* back button */
        back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(SelfReflectChoose.this, DashBoard.class));
            }
        });


        /* choose buttons */
//        // button 1
//        chooseButton1 = findViewById(R.id.choose_button_1);
//        chooseButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(b1 == 0){
//                    chooseButton1.setBackgroundResource(R.drawable.choose_status);
//                    b1 = 1;
//                    chosenNum++;
//                }else{
//                    chooseButton1.setBackgroundResource(R.drawable.not_choose);
//                    b1 = 0;
//                    chosenNum--;
//                }
//            }
//        });
//        // button 2
//        chooseButton2 = findViewById(R.id.choose_button_2);
//        chooseButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(b2 == 0){
//                    chooseButton2.setBackgroundResource(R.drawable.choose_status);
//                    b2 = 1;
//                    chosenNum++;
//                }else{
//                    chooseButton2.setBackgroundResource(R.drawable.not_choose);
//                    b2 = 0;
//                    chosenNum--;
//                }
//            }
//        });
//        // button 3
//        chooseButton3 = findViewById(R.id.choose_button_3);
//        chooseButton3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(b3 == 0){
//                    chooseButton3.setBackgroundResource(R.drawable.choose_status);
//                    b3 = 1;
//                    chosenNum++;
//                }else{
//                    chooseButton3.setBackgroundResource(R.drawable.not_choose);
//                    b3 = 0;
//                    chosenNum--;
//                }
//            }
//        });
//        // button 4
//        chooseButton4 = findViewById(R.id.choose_button_4);
//        chooseButton4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(b4 == 0){
//                    chooseButton4.setBackgroundResource(R.drawable.choose_status);
//                    b4 = 1;
//                    chosenNum++;
//                }else{
//                    chooseButton4.setBackgroundResource(R.drawable.not_choose);
//                    b4 = 0;
//                    chosenNum--;
//                }
//            }
//        });

        /* next button */
        nextButton = findViewById(R.id.next_button);
        nextButton.setEnabled(false);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelfReflectChoose.this, SelfReflectSave.class));
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
