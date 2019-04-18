package com.example.emotiontrack;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;


public class SavePopWindow extends Activity {

    Button dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_pop_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        getWindow().setLayout((int)(dm.widthPixels*0.8), (int)(dm.heightPixels*0.25));
        dashboard = findViewById(R.id.to_dashboard);
        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { ;
                startActivity(new Intent(getApplicationContext(), DashBoard.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                //startActivityForResult(new Intent(DashBoard.this, SelfReflectChoose.class), TO_SELF_REFLECT_CHOOSE);
            }
        });

    }
}
