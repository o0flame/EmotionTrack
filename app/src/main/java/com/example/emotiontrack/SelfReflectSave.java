package com.example.emotiontrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class SelfReflectSave extends AppCompatActivity {

    ImageButton back;
    ImageButton save;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_reflect_save);

        /* back button */
        back = findViewById(R.id.back_button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(SelfReflectSave.this, SelfReflectChoose.class));
            }
        });

        /* input text */
        inputText = findViewById(R.id.input_text);

        /* save button */
        save = findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!inputText.getText().toString().equals("")){
                    startActivity(new Intent(SelfReflectSave.this, SavePopWindow.class));
                    inputText.setText("");
                }
            }
        });

    }
}
